package com.macro.mall.portal.model;

import com.macro.mall.model.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CategoryProductBO {
	private Long id;

	@ApiModelProperty(value = "上机分类的编号：0表示一级分类")
	private Long parentId;

	private String name;

	@ApiModelProperty(value = "分类级别：0->1级；1->2级")
	private Integer level;

	private Integer productCount;

	private String productUnit;

	@ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
	private Integer navStatus;

	@ApiModelProperty(value = "显示状态：0->不显示；1->显示")
	private Integer showStatus;

	private Integer sort;

	@ApiModelProperty(value = "图标")
	private String icon;

	private String keywords;

	@ApiModelProperty(value = "描述")
	private String description;

	private List<PmsProduct> productList;


	private List<CategoryProductListBO> subCategoryList;


	private static final long serialVersionUID = 1L;


	public List<PmsProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<PmsProduct> productList) {
		this.productList = productList;
	}

	public List<CategoryProductListBO> getSubCategoryList() {
		return subCategoryList;
	}

	public void setSubCategoryList(List<CategoryProductListBO> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public Integer getNavStatus() {
		return navStatus;
	}

	public void setNavStatus(Integer navStatus) {
		this.navStatus = navStatus;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
