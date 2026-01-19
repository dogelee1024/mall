package com.macro.mall.common.api.dropshipping;

public class CategoryThirdDTO {

	/** 类目ID（下单 / 商品绑定用） */
	private String categoryId;

	/** 类目名称 */
	private String categoryName;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
