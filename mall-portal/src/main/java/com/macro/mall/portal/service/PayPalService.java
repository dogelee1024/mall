package com.macro.mall.portal.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayPalService {

	@Autowired
	private APIContext apiContext;

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