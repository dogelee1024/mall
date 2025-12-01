package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.service.OmsPortalOrderService;
import com.macro.mall.portal.service.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/paypal")
@Api(tags = "PayPalController")
@Tag(name = "PayPalController", description = "pay pal相关接口")
public class PayPalController {

	@Autowired
	private PayPalService payPalService;

	@Autowired
	private OmsPortalOrderService omsPortalOrderService;


	/**
	 * 创建支付
	 */
	@PostMapping("/create")
	@ApiOperation(value = "创建支付",notes = "必须为POST请求")
	public CommonResult<Map<String, Object>> createPayment(
		@RequestParam Double amount,
		@RequestParam String outTradeNo,
		@RequestParam String currency,
		@RequestParam String description
	) {
		try {

			// ————————————————————————
			// 1. 校验订单
			// ————————————————————————
			OmsOrderDetail order = omsPortalOrderService.detail(outTradeNo);
			if (order == null) {
				return CommonResult.failed("订单不存在");
			}
			if (order.getStatus() != 0) {
				return CommonResult.failed("订单状态异常，无法支付");
			}
			if(order.getPayAmount().compareTo(BigDecimal.valueOf(amount)) != 0){
				return CommonResult.failed("支付金额不对");
			}

			// ————————————————————————
			// 2. PayPal 相关配置
			// ————————————————————————
			String base = "http://www.fengshuibest.com";

			String cancelUrl = base + "/payment/cancel";   // 用户取消支付时跳转页面（前端页面）
			String successUrl = base + "/payment/success"; // PayPal 支付成功回调后端接口


			Payment payment = payPalService.createPayment(
				outTradeNo,
				amount,
				currency,
				"paypal",
				"sale",
				description,
				cancelUrl,
				successUrl
			);

			String approvalUrl = extractApprovalUrl(payment);
			if (approvalUrl == null) {
				log.error("未找到 PayPal approval_url, paymentId={}", payment.getId());
				return CommonResult.failed("未找到 PayPal 批准链接");
			}

			// ————————————————————————
			// 3. 返回前端
			// ————————————————————————
			Map<String, Object> result = new HashMap<>();
			result.put("paymentId", payment.getId());
			result.put("approvalUrl", approvalUrl);
			result.put("outTradeNo", outTradeNo);

			log.info("[PayPal] 创建支付成功 paymentId={} outTradeNo={}", payment.getId(), outTradeNo);

			return CommonResult.success(result);

		} catch (Exception e) {
			log.error("PayPal 创建支付失败", e);
			return CommonResult.failed("创建支付失败，请稍后重试");
		}
	}

	/**
	 * PayPal 回调执行付款
	 */
	@GetMapping("/execute")
	public CommonResult<Map<String, Object>> executePayment(
		@RequestParam String paymentId,
		@RequestParam String payerId
	) {

		try {

			Payment payment = payPalService.executePayment(paymentId, payerId);
			String status = payment.getState(); // completed, approved, failed...

			String outTradeNo = getInvoiceNumber(payment);

			log.info("[PayPal] 支付回调 paymentId={} state={} outTradeNo={}",
				paymentId, status, outTradeNo);

			if (outTradeNo == null) {
				return CommonResult.failed("回调缺失订单号");
			}

			// ————————————————————————
			// 1. 查询订单
			// ————————————————————————
			OmsOrderDetail order = omsPortalOrderService.detail(outTradeNo);
			if (order == null) {
				return CommonResult.failed("订单不存在");
			}

			// ————————————————————————
			// 2. 防重复回调
			// ————————————————————————
			if (order.getStatus() != 0) {
				log.info("[PayPal] 订单已支付，无需重复处理 outTradeNo={}", outTradeNo);
			} else {
				// ————————————————————————
				// 3. 支付成功时更新订单状态
				// ————————————————————————
				if ("approved".equalsIgnoreCase(status) || "completed".equalsIgnoreCase(status)) {

					omsPortalOrderService.paySuccessByOrderSn(outTradeNo, 1);

					log.info("[PayPal] 订单支付成功，状态已更新 outTradeNo={}", outTradeNo);
				}
			}

			// ————————————————————————
			// 4. 返回前端
			// ————————————————————————
			Map<String, Object> data = new HashMap<>();
			data.put("paymentId", paymentId);
			data.put("status", status);
			data.put("transactionId", getTransactionId(payment));
			data.put("outTradeNo", outTradeNo);

			return CommonResult.success(data);

		} catch (PayPalRESTException e) {
			log.error("[PayPal] 支付执行失败", e);
			return CommonResult.failed("PayPal 支付失败，请稍后尝试");
		}
	}

	/**
	 * 查询 PayPal 支付详情
	 */
	@GetMapping("/payment/{paymentId}")
	public CommonResult<Map<String, Object>> getPayment(@PathVariable String paymentId) {

		try {
			Payment payment = payPalService.getPaymentDetails(paymentId);

			Map<String, Object> result = new HashMap<>();
			result.put("status", payment.getState());
			result.put("createTime", payment.getCreateTime());
			result.put("updateTime", payment.getUpdateTime());
			result.put("transactions", payment.getTransactions());

			return CommonResult.success(result);

		} catch (Exception e) {
			log.error("[PayPal] 查询支付失败 paymentId={}", paymentId, e);
			return CommonResult.failed("查询失败");
		}
	}


	// ——————————————————————————————————
	// 工具方法
	// ——————————————————————————————————

	private String extractApprovalUrl(Payment payment) {
		for (Links link : payment.getLinks()) {
			if ("approval_url".equalsIgnoreCase(link.getRel())) {
				return link.getHref();
			}
		}
		return null;
	}

	private String getTransactionId(Payment payment) {
		try {
			return payment.getTransactions()
				.get(0).getRelatedResources()
				.get(0).getSale().getId();
		} catch (Exception e) {
			return null;
		}
	}

	private String getInvoiceNumber(Payment payment) {
		try {
			return payment.getTransactions().get(0).getInvoiceNumber();
		} catch (Exception e) {
			return null;
		}
	}
}

