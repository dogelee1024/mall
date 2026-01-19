package com.macro.mall.portal.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.macro.mall.common.api.dropshipping.AccessToken;
import com.macro.mall.common.api.dropshipping.InventoryData;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.model.DropshippingProductOrderBO;
import com.macro.mall.portal.model.DropshippingProductQuantityBO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DropshippingApiService {
	@Value("${dropshipping.api}")
	private String api;

	@Value("${dropshipping.secret}")
	private String  secret;

	@Autowired
	RedisService redisService;

	private static final String CREATE_ORDER_V3 = "/api2.0/v1/shopping/order/createOrderV3";
	private static final String PRODUCT_STOCK_BYID = "/api2.0/v1/product/stock/queryBySku";
	private static final String PRODUCT_DETAIL = "/api2.0/v1/product/query";
	private static final String ACCESS_TOKEN = "/api2.0/v1/authentication/getAccessToken";



	public List<InventoryData> getProductStockBySku(String sku) {
		String uri = api + PRODUCT_STOCK_BYID;
		String accessToken = getAccessToken();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("sku", sku);
		HttpRequest request = HttpRequest.get(uri)
			.header("CJ-Access-Token", accessToken)
			.form(paramMap);

		HttpResponse response = request.execute();

		if (!response.isOk()) {
			throw new RuntimeException("CJ product detail request failed");
		}

		String body = response.body();
		JSONObject res = JSONObject.parseObject(body);
		log.info("query stock from dropshipping, request:{} res:{}", sku, res);
		String data = res.getString("data");
		log.info("query stock from dropshipping, request:{} data:{}", sku, data);
		return JSONArray.parseArray(data, InventoryData.class);
	}

	public boolean createOrder(OmsOrder orderDetail, List<DropshippingProductQuantityBO> products, String shippingCountryCode) {
		DropshippingProductOrderBO order = new DropshippingProductOrderBO();
		order.setProducts(products);

		order.setOrderNumber(orderDetail.getOrderSn());
		//todo
		order.setShippingCountryCode(shippingCountryCode);
		order.setShippingCountry(orderDetail.getReceiverCountry());
		order.setShippingProvince(orderDetail.getReceiverProvince());
		order.setShippingCity(orderDetail.getReceiverCity());
		order.setShippingAddress(orderDetail.getReceiverDetailAddress());
		order.setShippingCustomerName(orderDetail.getReceiverFirstName()+" " +orderDetail.getReceiverSecondName());
		order.setFromCountryCode(products.get(0).getFromCountryCode());
		order.setLogisticName("CJ packet ordinary");

		String uri = api + CREATE_ORDER_V3;
		String accessToken = getAccessToken();
		HttpRequest request = HttpRequest.post(uri)
			.header("CJ-Access-Token", accessToken)
			.body(JSONObject.toJSONString(order));

		HttpResponse response = request.execute();
		String body = response.body();
		System.out.println(body);
		JSONObject res = JSONObject.parseObject(body);
		Integer code = res.getInteger("code");
		if(code.equals(200)){
			return true;
		}else{
			return false;
		}
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
