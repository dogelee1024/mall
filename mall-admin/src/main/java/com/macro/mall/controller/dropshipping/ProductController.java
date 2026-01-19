package com.macro.mall.controller.dropshipping;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.macro.mall.bo.WarehouseInfo;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.api.dropshipping.AccessToken;
import com.macro.mall.common.api.dropshipping.CategoryFirstDTO;
import com.macro.mall.common.api.dropshipping.ContentItem;
import com.macro.mall.common.api.dropshipping.PageData;
import com.macro.mall.common.api.dropshipping.ProductDetailDTO;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.dto.DropshippingProductListParam;
import com.macro.mall.manager.DropshippingManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/dropshipping")
@Api(tags = "DropShippingProductController")
@Tag(name = "DropShippingProductController", description = "dropShipping管理")
public class ProductController {

    @Autowired
    DropshippingManage dropshippingManage;


    @ApiOperation("商品列表")
    @GetMapping(value = "/product/list")
    @ResponseBody
    public CommonResult<CommonPage<ContentItem>> getProductList(DropshippingProductListParam param) {
        return dropshippingManage.getProductList(param);
    }

    @ApiOperation("商品详情")
    @GetMapping(value = "/product/details")
    @ResponseBody
    public CommonResult<ProductDetailDTO> getProductDetails(int type, String pid) {
        return CommonResult.success(dropshippingManage.getProductDetail(type, pid));
    }

    @ApiOperation("仓库列表")
    @GetMapping(value = "/warehouse/list")
    @ResponseBody
    public CommonResult<List<WarehouseInfo>> getWarehouseList() {
        return dropshippingManage.getWareHouseList();
    }


    @ApiOperation("分类列表")
    @GetMapping(value = "/category/list")
    @ResponseBody
    public CommonResult<List<CategoryFirstDTO>> getCategoryList() {
        return dropshippingManage.getCategoryList();
    }
}
