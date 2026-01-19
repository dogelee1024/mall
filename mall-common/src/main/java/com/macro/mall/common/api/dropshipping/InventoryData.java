package com.macro.mall.common.api.dropshipping;

import java.util.List;

public class InventoryData {
	private String areaEn;
	private int areaId;
	private String countryCode;
	private int totalInventoryNum;
	private int cjInventoryNum;
	private int factoryInventoryNum;
	private String countryNameEn;

	public String getAreaEn() {
		return areaEn;
	}

	public void setAreaEn(String areaEn) {
		this.areaEn = areaEn;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getTotalInventoryNum() {
		return totalInventoryNum;
	}

	public void setTotalInventoryNum(int totalInventoryNum) {
		this.totalInventoryNum = totalInventoryNum;
	}

	public int getCjInventoryNum() {
		return cjInventoryNum;
	}

	public void setCjInventoryNum(int cjInventoryNum) {
		this.cjInventoryNum = cjInventoryNum;
	}

	public int getFactoryInventoryNum() {
		return factoryInventoryNum;
	}

	public void setFactoryInventoryNum(int factoryInventoryNum) {
		this.factoryInventoryNum = factoryInventoryNum;
	}

	public String getCountryNameEn() {
		return countryNameEn;
	}

	public void setCountryNameEn(String countryNameEn) {
		this.countryNameEn = countryNameEn;
	}
}
