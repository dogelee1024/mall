package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 生成订单时传入的参数
 * Created by macro on 2018/8/30.
 */
@Data
@EqualsAndHashCode
public class OrderParam {
    @ApiModelProperty("收货地址ID")
    private Long memberReceiveAddressId;
    @ApiModelProperty("优惠券ID")
    private Long couponId;
    @ApiModelProperty("使用的积分数")
    private Integer useIntegration;
    @ApiModelProperty("支付方式")
    private Integer payType;
    @ApiModelProperty("被选中的购物车商品ID")
    private List<Long> cartIds;

    @ApiModelProperty(value = "收票人firstName")
    private String billFirstName;

    @ApiModelProperty(value = "收票人secondName")
    private String billSecondName;

    @ApiModelProperty(value = "收票人电话")
    private String billReceiverPhone;

    @ApiModelProperty(value = "收票人邮箱")
    private String billReceiverEmail;

    @ApiModelProperty(value = "收票邮编")
    private String billPostCode;

    @ApiModelProperty(value = "收票国家")
    private String billCountry;

    @ApiModelProperty(value = "收票省")
    private String billProvince;

    @ApiModelProperty(value = "收票城市")
    private String billCity;

    @ApiModelProperty(value = "收票区")
    private String billRegion;

    @ApiModelProperty(value = "收票详细地址")
    private String billDetailAddress;

    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;

    @ApiModelProperty(value = "收货人firstName")
    private String receiverFirstName;

    @ApiModelProperty(value = "收货人secondName")
    private String receiverSecondName;

    @ApiModelProperty(value = "收货人电话")
    private String receiverPhone;

    @ApiModelProperty(value = "收货人邮编")
    private String receiverPostCode;

    @ApiModelProperty(value = "收货人国家")
    private String receiverCountry;

    @ApiModelProperty(value = "省份/直辖市")
    private String receiverProvince;

    @ApiModelProperty(value = "城市")
    private String receiverCity;

    @ApiModelProperty(value = "区")
    private String receiverRegion;

    @ApiModelProperty(value = "详细地址")
    private String receiverDetailAddress;

}
