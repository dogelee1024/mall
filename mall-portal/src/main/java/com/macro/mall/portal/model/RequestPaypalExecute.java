package com.macro.mall.portal.model;

import org.springframework.web.bind.annotation.RequestParam;

public class RequestPaypalExecute {
	private String paymentId;
	private String payerId;
	private String outTradeNo;
	private String ecToken;
	private String orderId;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}


	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getEcToken() {
		return ecToken;
	}

	public void setEcToken(String ecToken) {
		this.ecToken = ecToken;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
