package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Service
public class PayPalService {

	@Autowired
	private APIContext apiContext;
	@Autowired
	private PayPalHttpClient payPalHttpClient;

	public Map<String, Object> createPaymentDirect(OmsOrder order) {
			try {

				// ————————————————————————
				// 2. PayPal 相关配置
				// ————————————————————————
				String base = "http://www.fengshuibest.com";

				String cancelUrl = base + "/payment/cancel";   // 用户取消支付时跳转页面（前端页面）
				String successUrl = base + "/payment/success"; // PayPal 支付成功回调后端接口

				String outTradeNo = order.getOrderSn();
				Double amount = order.getPayAmount().doubleValue();
				Payment payment = createPayment(
					outTradeNo,
					amount,
					"USD",
					"paypal",
					"sale",
					"",
					cancelUrl,
					successUrl
				);

				String approvalUrl = extractApprovalUrl(payment);
				if (approvalUrl == null) {
					log.error("未找到 PayPal approval_url, paymentId={}", payment.getId());
					//return CommonResult.failed("未找到 PayPal 批准链接");
				}

				// ————————————————————————
				// 3. 返回前端
				// ————————————————————————
				Map<String, Object> result = new HashMap<>();
				result.put("paymentId", payment.getId());
				result.put("approvalUrl", approvalUrl);
				result.put("outTradeNo", outTradeNo);

				log.info("[PayPal] 创建支付成功 paymentId={} outTradeNo={}", payment.getId(), outTradeNo);

				return result;

			} catch (Exception e) {
				log.error("PayPal 创建支付失败", e);
			}
			return null;
	}

	public Map<String, Object> createPaypalOrder(OmsOrder order) {

		OrdersCreateRequest request = new OrdersCreateRequest();
		request.prefer("return=representation");

		request.requestBody(new OrderRequest()
			.checkoutPaymentIntent("CAPTURE")
			.purchaseUnits(List.of(
				new PurchaseUnitRequest()
					.referenceId(order.getOrderSn())
					.amountWithBreakdown(new AmountWithBreakdown()
						.currencyCode("USD")
						.value(order.getPayAmount().toString())
					)
			))
		);

		try {
			HttpResponse<com.paypal.orders.Order> response = payPalHttpClient.execute(request);
			com.paypal.orders.Order paypalOrder = response.result();

			Map<String, Object> result = new HashMap<>();
			result.put("orderId", paypalOrder.id());   // ⭐ 给前端
			result.put("outTradeNo", order.getOrderSn());

			return result;

		} catch (Exception e) {
			log.error("创建 PayPal Order 失败", e);
			return null;
		}
	}

	private String extractApprovalUrl(Payment payment) {
		for (Links link : payment.getLinks()) {
			if ("approval_url".equalsIgnoreCase(link.getRel())) {
				return link.getHref();
			}
		}
		return null;
	}

	/**
	 * 创建支付订单
	 */
	public Payment createPayment(
		String outTradeNo,
		Double total,
		String currency,
		String method,
		String intent,
		String description,
		String cancelUrl,
		String successUrl) throws PayPalRESTException {

		Amount amount = new Amount();
		amount.setCurrency(currency);
		amount.setTotal(String.format("%.2f", new BigDecimal(total).setScale(2, RoundingMode.HALF_UP)));

		Transaction transaction = new Transaction();
		transaction.setDescription(description);
		transaction.setAmount(amount);
		transaction.setInvoiceNumber(outTradeNo);

		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod(method);

		Payment payment = new Payment();
		payment.setIntent(intent);
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(cancelUrl);
		redirectUrls.setReturnUrl(successUrl);
		payment.setRedirectUrls(redirectUrls);

		return payment.create(apiContext);
	}

	/**
	 * 执行支付（捕获支付）
	 */
	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		Payment payment = new Payment();
		payment.setId(paymentId);

		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		return payment.execute(apiContext, paymentExecution);
	}

	/**
	 * 查询支付详情
	 */
	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		return Payment.get(apiContext, paymentId);
	}

	/**
	 * 退款
	 */
	public Refund refundPayment(String captureId, Double amount, String currency) throws PayPalRESTException {
		Capture capture = new Capture();
		capture.setId(captureId);

		Amount refundAmount = new Amount();
		refundAmount.setCurrency(currency);
		refundAmount.setTotal(String.format("%.2f", new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP)));

		RefundRequest refundRequest = new RefundRequest();
		refundRequest.setAmount(refundAmount);

		return capture.refund(apiContext, refundRequest);
	}
}