package com.macro.mall.portal.model;

public class DropshippingProductQuantityBO {
	private String sku;
	private int quantity;
	private String fromCountryCode;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFromCountryCode() {
		return fromCountryCode;
	}

	public void setFromCountryCode(String fromCountryCode) {
		this.fromCountryCode = fromCountryCode;
	}
}
