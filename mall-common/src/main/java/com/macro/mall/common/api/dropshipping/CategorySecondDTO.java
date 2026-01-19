package com.macro.mall.common.api.dropshipping;

import java.util.List;

public class CategorySecondDTO {

	/** 二级类目名称 */
	private String categorySecondName;

	/** 三级类目列表 */
	private List<CategoryThirdDTO> categorySecondList;

	public String getCategorySecondName() {
		return categorySecondName;
	}

	public void setCategorySecondName(String categorySecondName) {
		this.categorySecondName = categorySecondName;
	}

	public List<CategoryThirdDTO> getCategorySecondList() {
		return categorySecondList;
	}

	public void setCategorySecondList(List<CategoryThirdDTO> categorySecondList) {
		this.categorySecondList = categorySecondList;
	}
}
