package com.macro.mall.common.api.dropshipping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class ProductDetailDTO {

	/** 商品ID（SPU） */
	private String pid;

	/** 商品SPU价格（展示用，勿用于下单） */
	private String sellPrice;

	/** 建议售价 */
	private String suggestSellPrice;

	/** 商品SKU（SPU级） */
	private String productSku;

	/** 商品英文名 */
	private String productNameEn;

	/** 商品中文名集合 */
	private Set<String> productNameSet;

	/** 商品描述（HTML） */
	private String description;

	/** 商品状态：3=正常 */
	private String status;

	/** 商品类型 */
	private String productType;

	/** 商品类目ID */
	private String categoryId;

	/** 类目完整路径 */
	private String categoryName;

	/** 商品主图集合（推荐使用） */
	private List<String> productImageSet;

	/** 商品规格Key（如：颜色） */
	private List<String> productKeySet;

	/** 商品规格英文 */
	private String productKeyEn;

	/** 商品属性 */
	private List<String> productProSet;

	/** 商品英文属性 */
	private List<String> productProEnSet;

	/** 材质 */
	private Set<String> materialNameSet;
	private Set<String> materialNameEnSet;
	private Set<String> materialKeySet;

	/** 包装 */
	private Set<String> packingNameSet;
	private Set<String> packingNameEnSet;
	private Set<String> packingKeySet;

	/** 申报信息 */
	private String entryCode;
	private String entryName;
	private String entryNameEn;

	/** 商品重量范围（字符串） */
	private String productWeight;

	/** 包装重量范围 */
	private String packingWeight;

	/** 是否测试商品 */
	private Boolean isTestProduct;

	/** 铺货数量 */
	private Integer listedNum;

	/** 来源 */
	private Integer sourceFrom;

/*	*//** 创建时间 *//*
	private OffsetDateTime createrTime;*/

	/** SKU 变体列表（最重要） */
	private List<ProductVariantDTO> variants;

}
