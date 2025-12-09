package com.macro.mall.portal.model;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import java.util.List;

public class CategoryProductListBO extends PmsProductCategory {

	private List<PmsProduct> productList;

	public List<PmsProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<PmsProduct> productList) {
		this.productList = productList;
	}
}
