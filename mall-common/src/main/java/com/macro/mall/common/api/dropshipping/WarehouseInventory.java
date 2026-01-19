package com.macro.mall.common.api.dropshipping;

public class WarehouseInventory {
	private String areaEn;
	private Integer areaId;
	private String countryCode;

	/** 总库存 */
	private Integer totalInventoryNum;

	/** CJ 仓库存 */
	private Integer cjInventoryNum;

	/** 工厂库存 */
	private Integer factoryInventoryNum;

	private String countryNameEn;

	public String getAreaEn() {
		return areaEn;
	}

	public void setAreaEn(String areaEn) {
		this.areaEn = areaEn;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getTotalInventoryNum() {
		return totalInventoryNum;
	}

	public void setTotalInventoryNum(Integer totalInventoryNum) {
		this.totalInventoryNum = totalInventoryNum;
	}

	public Integer getCjInventoryNum() {
		return cjInventoryNum;
	}

	public void setCjInventoryNum(Integer cjInventoryNum) {
		this.cjInventoryNum = cjInventoryNum;
	}

	public Integer getFactoryInventoryNum() {
		return factoryInventoryNum;
	}

	public void setFactoryInventoryNum(Integer factoryInventoryNum) {
		this.factoryInventoryNum = factoryInventoryNum;
	}

	public String getCountryNameEn() {
		return countryNameEn;
	}

	public void setCountryNameEn(String countryNameEn) {
		this.countryNameEn = countryNameEn;
	}
}
