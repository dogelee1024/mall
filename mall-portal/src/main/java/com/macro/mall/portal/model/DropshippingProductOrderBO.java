package com.macro.mall.portal.model;

import java.util.List;

public class DropshippingProductOrderBO {

	private String orderNumber;

	private String shippingZip;
	private String shippingCountry;
	private String shippingCountryCode;
	private String shippingProvince;
	private String shippingCity;
	private String shippingCounty;

	private String shippingPhone;
	private String shippingCustomerName;

	private String shippingAddress;
	private String shippingAddress2;

	private String taxId;
	private String remark;
	private String email;

	private String consigneeID;
	private String shopAmount;

	private String logisticName;
	private String fromCountryCode;

	private String houseNumber;
	private String platform;

	private String iossType;
	private String iossNumber;

	private List<DropshippingProductQuantityBO> products;

	// ===== getter / setter =====

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getShippingZip() {
		return shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		this.shippingZip = shippingZip;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingCountryCode() {
		return shippingCountryCode;
	}

	public void setShippingCountryCode(String shippingCountryCode) {
		this.shippingCountryCode = shippingCountryCode;
	}

	public String getShippingProvince() {
		return shippingProvince;
	}

	public void setShippingProvince(String shippingProvince) {
		this.shippingProvince = shippingProvince;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingCounty() {
		return shippingCounty;
	}

	public void setShippingCounty(String shippingCounty) {
		this.shippingCounty = shippingCounty;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public String getShippingCustomerName() {
		return shippingCustomerName;
	}

	public void setShippingCustomerName(String shippingCustomerName) {
		this.shippingCustomerName = shippingCustomerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingAddress2() {
		return shippingAddress2;
	}

	public void setShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConsigneeID() {
		return consigneeID;
	}

	public void setConsigneeID(String consigneeID) {
		this.consigneeID = consigneeID;
	}

	public String getShopAmount() {
		return shopAmount;
	}

	public void setShopAmount(String shopAmount) {
		this.shopAmount = shopAmount;
	}

	public String getLogisticName() {
		return logisticName;
	}

	public void setLogisticName(String logisticName) {
		this.logisticName = logisticName;
	}

	public String getFromCountryCode() {
		return fromCountryCode;
	}

	public void setFromCountryCode(String fromCountryCode) {
		this.fromCountryCode = fromCountryCode;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getIossType() {
		return iossType;
	}

	public void setIossType(String iossType) {
		this.iossType = iossType;
	}

	public String getIossNumber() {
		return iossNumber;
	}

	public void setIossNumber(String iossNumber) {
		this.iossNumber = iossNumber;
	}




	public List<DropshippingProductQuantityBO> getProducts() {
		return products;
	}

	public void setProducts(List<DropshippingProductQuantityBO> products) {
		this.products = products;
	}
}
