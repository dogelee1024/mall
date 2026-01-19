package com.macro.mall.bo;

public class WarehouseInfo {
	/** 仓库中文名 */
	private String areaCn;

	/** 仓库英文名 */
	private String areaEn;

	/** 仓库数值型 ID */
	private Integer areaId;

	/** 国家编码（ISO） */
	private String countryCode;

	/** 国家英文名 */
	private String nameEn;

	/** 国家编码值（通常同 countryCode） */
	private String valueEn;

	/** 是否禁用 */
	private Boolean disabled;

	/** 多语言名称 */
	private String zh;
	private String en;
	private String de;
	private String fr;
	private String th;

	/** 字符串形式 ID */
	private String id;

	// ===== getter / setter =====

	public String getAreaCn() {
		return areaCn;
	}

	public void setAreaCn(String areaCn) {
		this.areaCn = areaCn;
	}

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

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getValueEn() {
		return valueEn;
	}

	public void setValueEn(String valueEn) {
		this.valueEn = valueEn;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getTh() {
		return th;
	}

	public void setTh(String th) {
		this.th = th;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
