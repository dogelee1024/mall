package com.macro.mall.common.api.dropshipping;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductVariantDTO {
	/** 变体ID（下单必用） */
	private String vid;

	/** 所属商品ID */
	private String pid;

	/** 变体SKU */
	private String variantSku;

	/** 规格值（如：White / Blue） */
	private String variantKey;

	/** 变体英文名 */
	private String variantNameEn;

	/** 变体图片 */
	private String variantImage;

	/** 实际进货价（USD，下单用） */
	private BigDecimal variantSellPrice;

	/** 建议零售价 */
	private BigDecimal variantSugSellPrice;

	/** 单位 */
	private String variantUnit;

	/** 重量（g） */
	private BigDecimal variantWeight;

	/** 尺寸（mm） */
	private Integer variantLength;
	private Integer variantWidth;
	private Integer variantHeight;

	/** 体积 */
	private Long variantVolume;

	/** 尺寸标准字符串 */
	private String variantStandard;

	/** 规格属性JSON字符串 */
	private String variantProperty;

	/** 创建时间（时间戳） */
	private Long createTime;
}
