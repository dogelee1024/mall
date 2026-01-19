package com.macro.mall.common.api.dropshipping;

public class VariantCountryInventory {
	private String countryCode;

	/** 总库存 */
	private Integer totalInventory;

	/** CJ 仓库存 */
	private Integer cjInventory;

	/** 工厂库存 */
	private Integer factoryInventory;

	/** 已验证仓库数量 */
	private Integer verifiedWarehouse;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getTotalInventory() {
		return totalInventory;
	}

	public void setTotalInventory(Integer totalInventory) {
		this.totalInventory = totalInventory;
	}

	public Integer getCjInventory() {
		return cjInventory;
	}

	public void setCjInventory(Integer cjInventory) {
		this.cjInventory = cjInventory;
	}

	public Integer getFactoryInventory() {
		return factoryInventory;
	}

	public void setFactoryInventory(Integer factoryInventory) {
		this.factoryInventory = factoryInventory;
	}

	public Integer getVerifiedWarehouse() {
		return verifiedWarehouse;
	}

	public void setVerifiedWarehouse(Integer verifiedWarehouse) {
		this.verifiedWarehouse = verifiedWarehouse;
	}
}
