package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.units.qual.A;

@Data
@EqualsAndHashCode
public class DropshippingProductListParam {


    @ApiModelProperty("仓库位置")
    private String countryCode;

    @ApiModelProperty("分类")
    private String categoryId;

    @ApiModelProperty("资质证书: 0-NO 1-YES")
    private Integer hasCertification;

    @ApiModelProperty("库存类型: 0-All 1-已核实 2-未合适")
    private Integer verifiedWarehouse;

    @ApiModelProperty("发布时间")
    private Long timeStart;

    @ApiModelProperty("库存")
    private Integer startWarehouseInventory = 1;

    @ApiModelProperty("每页行数")
    private Integer pageSize;

    @ApiModelProperty("页码")
    private Integer pageNum;

}
