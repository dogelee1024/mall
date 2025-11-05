package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.service.OmsPortalOrderService;
import com.macro.mall.portal.service.PayPalService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/paypal")
public class PayPalController {

	@Autowired
	private PayPalService payPalService;

	@Autowired
	private OmsPortalOrderService omsPortalOrderService;


	/**
	 * 创建支付
	 */
	@PostMapping("/create")
	public CommonResult<Map<String, Object>> createPayment(
		@RequestParam Double amount,
		@RequestParam String outTradeNo,
		@RequestParam String currency,
		@RequestParam String description) {

		try {

			// 1. 验证订单是否存在且未支付
			OmsOrderDetail order = omsPortalOrderService.detail(outTradeNo);
			if (order == null) {
				return CommonResult.failed("订单不存在");
			}
			if (order.getStatus() != 0) {
				return CommonResult.failed("订单状态异常");
			}

			String cancelUrl = "http://yourdomain.com/payment/cancel";
			String successUrl = "http://yourdomain.com/payment/success";

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

			Map<String, Object> response = new HashMap<>();
			response.put("paymentId", payment.getId());
			response.put("approvalUrl", getApprovalUrl(payment));
			response.put("outTradeNo", outTradeNo);

			return CommonResult.success(response);

		} catch (PayPalRESTException e) {
			return CommonResult.failed();
		}
	}

	/**
	 * 支付成功回调
	 */
	@GetMapping("/execute")
	public CommonResult<Map<String, Object>> executePayment(
		@RequestParam String paymentId,
		@RequestParam String payerId) {

		try {
			Payment payment = payPalService.executePayment(paymentId, payerId);

			Map<String, Object> response = new HashMap<>();
			response.put("status", payment.getState());
			response.put("transactionId", getTransactionId(payment));
			response.put("paymentId", payment.getId());

			// 这里可以更新订单状态到数据库
			updateOrderStatus(payment);

			return CommonResult.success(response);

		} catch (PayPalRESTException e) {
			return CommonResult.failed();
		}
	}

	/**
	 * 查询支付状态
	 */
	@GetMapping("/payment/{paymentId}")
	public CommonResult<Map<String, Object>> getPayment(@PathVariable String paymentId) {
		try {
			Payment payment = payPalService.getPaymentDetails(paymentId);

			Map<String, Object> response = new HashMap<>();
			response.put("status", payment.getState());
			response.put("createTime", payment.getCreateTime());
			response.put("updateTime", payment.getUpdateTime());
			response.put("transactions", payment.getTransactions());

			return CommonResult.success(response);

		} catch (PayPalRESTException e) {
			return CommonResult.failed();
		}
	}

	private String getApprovalUrl(Payment payment) {
		return payment.getLinks().stream()
			.filter(link -> link.getRel().equals("approval_url"))
			.findFirst()
			.orElseThrow(() -> new RuntimeException("No approval URL found"))
			.getHref();
	}

	private String getTransactionId(Payment payment) {
		return payment.getTransactions().get(0).getRelatedResources().get(0)
			.getSale().getId();
	}

	private String getOutTradeNo(Payment payment) {
		return payment.getTransactions().get(0).getInvoiceNumber();
	}

	private void updateOrderStatus(Payment payment) {
		// 实现更新订单状态的逻辑
		String paymentId = payment.getId();
		String status = payment.getState();
		String outTradeNo = getOutTradeNo(payment);
		omsPortalOrderService.paySuccessByOrderSn(outTradeNo,1);


		// 更新数据库中的订单状态
		// orderService.updateOrderStatus(paymentId, status);
	}
}