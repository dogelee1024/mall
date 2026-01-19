package com.macro.mall.common.api.dropshipping;

import java.util.List;

public class CategoryFirstDTO {
	/** 一级类目名称 */
	private String categoryFirstName;

	/** 二级类目列表 */
	private List<CategorySecondDTO> categoryFirstList;

	public String getCategoryFirstName() {
		return categoryFirstName;
	}

	public void setCategoryFirstName(String categoryFirstName) {
		this.categoryFirstName = categoryFirstName;
	}

	public List<CategorySecondDTO> getCategoryFirstList() {
		return categoryFirstList;
	}

	public void setCategoryFirstList(List<CategorySecondDTO> categoryFirstList) {
		this.categoryFirstList = categoryFirstList;
	}
}
