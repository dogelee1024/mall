package com.macro.mall.manager;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.macro.mall.bo.WarehouseInfo;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.api.dropshipping.AccessToken;
import com.macro.mall.common.api.dropshipping.CategoryFirstDTO;
import com.macro.mall.common.api.dropshipping.ContentItem;
import com.macro.mall.common.api.dropshipping.PageData;
import com.macro.mall.common.api.dropshipping.Product;
import com.macro.mall.common.api.dropshipping.ProductDetailDTO;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.dto.DropshippingProductListParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DropshippingManage {

	@Value("${dropshipping.api}")
	private String api;

	@Value("${dropshipping.secret}")
	private String  secret;

	@Autowired
	RedisService redisService;

	private static final String CATEGORY_LIST = "/api2.0/v1/product/getCategory";
	private static final String WARE_HOUSE_LIST = "/api2.0/v1/product/globalWarehouseList";
	private static final String PRODUCT_LIST = "/api2.0/v1/product/listV2";
	private static final String PRODUCT_DETAIL = "/api2.0/v1/product/query";
	private static final String ACCESS_TOKEN = "/api2.0/v1/authentication/getAccessToken";

	public CommonResult<List<CategoryFirstDTO>> getCategoryList() {
		String uri = api + CATEGORY_LIST;

		String accessToken = getAccessToken();
		HttpRequest request = HttpRequest.get(uri)
			.header("CJ-Access-Token", accessToken);

		HttpResponse response = request.execute();

		if (!response.isOk()) {
			throw new RuntimeException("CJ product list request failed");
		}

		String body = response.body();

		JSONObject res = JSONObject.parseObject(body);
		String data = res.getString("data");
		List<CategoryFirstDTO> categoryFirstDTOS = JSONArray.parseArray(data, CategoryFirstDTO.class);
		return CommonResult.success(categoryFirstDTOS);
	}

	public CommonResult<List<WarehouseInfo>> getWareHouseList() {
		String uri = api + WARE_HOUSE_LIST;

		String accessToken = getAccessToken();
		HttpRequest request = HttpRequest.get(uri)
			.header("CJ-Access-Token", accessToken);

		HttpResponse response = request.execute();

		if (!response.isOk()) {
			throw new RuntimeException("CJ product list request failed");
		}

		String body = response.body();

		JSONObject res = JSONObject.parseObject(body);
		String data = res.getString("data");
		List<WarehouseInfo> warehouseInfos = JSONArray.parseArray(data, WarehouseInfo.class);
		return CommonResult.success(warehouseInfos);
	}

	public CommonResult<CommonPage<ContentItem>> getProductList(DropshippingProductListParam param) {
		String uri = api + PRODUCT_LIST;

		String accessToken = getAccessToken();
		Map<String, Object> paramMap = BeanUtil.beanToMap(param, false, true);
		paramMap.put("page", param.getPageNum());
		paramMap.put("size", param.getPageSize());
		HttpRequest request = HttpRequest.get(uri)
			.header("CJ-Access-Token", accessToken)
			.form(paramMap);

		HttpResponse response = request.execute();

		if (!response.isOk()) {
			throw new RuntimeException("CJ product list request failed");
		}

		String body = response.body();

        /*JSONObject jsonObject = JSONUtil.parseObj(body);
        Object data = jsonObject.get("data");*/
		JSONObject res = JSONObject.parseObject(body);
		String data = res.getString("data");
		PageData pageData = JSONObject.parseObject(data, PageData.class);
		List<ContentItem> content = pageData.getContent();
		Integer pageNumber = pageData.getPageNumber();
		Integer pageSize = pageData.getPageSize();
		Integer totalRecords = pageData.getTotalRecords();


		CommonPage<ContentItem> result = new CommonPage<>();
		content.forEach(c -> {
			List<Product> productList = c.getProductList();
			productList.forEach(p -> {
				p.setCountryCode(param.getCountryCode());
			});
		});
		result.setList(content);
		result.setTotal(Long.valueOf(totalRecords));
		result.setPageNum(pageNumber);
		result.setPageSize(pageSize);
		return CommonResult.success(result);
	}

	public ProductDetailDTO getProductDetail(int type,  String productId) {
		String uri = api + PRODUCT_DETAIL;
		String accessToken = getAccessToken();
		Map<String, Object> paramMap = new HashMap<>();
		switch (type){
			case 1:
				paramMap.put("pid", productId);
				break;
				case 2:
					paramMap.put("productSku", productId);
					break;
		}
		HttpRequest request = HttpRequest.get(uri)
			.header("CJ-Access-Token", accessToken)
			.form(paramMap);

		HttpResponse response = request.execute();

		if (!response.isOk()) {
			throw new RuntimeException("CJ product detail request failed");
		}

		String body = response.body();

        /*JSONObject jsonObject = JSONUtil.parseObj(body);
        Object data = jsonObject.get("data");*/
		JSONObject res = JSONObject.parseObject(body);
		String data = res.getString("data");
		System.out.println(data);
		ProductDetailDTO productDetailDTO = JSONObject.parseObject(data, ProductDetailDTO.class);
		return productDetailDTO;
	}


	public String getAccessToken(){
		String key = "dropshipping:access_token";
		String cache = (String)redisService.get(key);
		if(cache!=null){
			AccessToken accessToken = JSONObject.parseObject(cache, AccessToken.class);
			if(accessToken!=null){
				String accessTokenExpiryDate = accessToken.getAccessTokenExpiryDate();
				DateTime expireTime = DateUtil.parse(accessTokenExpiryDate);
				if(expireTime.isAfter(new DateTime())){
					return accessToken.getAccessToken();
				}
			}
		}
		String uri = api + ACCESS_TOKEN;

		JSONObject param = new JSONObject();
		param.put("apiKey", secret);

		HttpRequest request = HttpRequest.post(uri)
			.header("Content-Type", "application/json")
			.body(param.toJSONString());

		HttpResponse response = request.execute();

		if (!response.isOk()) {
			throw new RuntimeException("CJ product list request failed");
		}

		String body = response.body();
		JSONObject res = JSONObject.parseObject(body);
		String data = res.getString("data");
		AccessToken accessToken = JSONObject.parseObject(data, AccessToken.class);
		redisService.set(key, JSONObject.toJSONString(accessToken));
		return accessToken.getAccessToken();
	}

}
