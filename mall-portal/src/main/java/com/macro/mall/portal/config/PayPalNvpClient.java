package com.macro.mall.portal.config;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class PayPalNvpClient {

	private static final String VERSION = "204.0";

	@Resource
	private PayPalNvpProperties properties;

	public Map<String, String> getExpressCheckoutDetails(String token) {
		Map<String, Object> params = new HashMap<>();
		params.put("METHOD", "GetExpressCheckoutDetails");
		params.put("VERSION", VERSION);
		params.put("USER", properties.getUsername());
		params.put("PWD", properties.getPassword());
		params.put("SIGNATURE", properties.getSignature());
		params.put("TOKEN", token);


		// 使用 Hutool HttpRequest 可设置超时和请求头
		HttpResponse resp = HttpRequest.post(properties.getApiEndpoint())
			.form(params)              // application/x-www-form-urlencoded
			.timeout(5000)             // 5秒超时
			.execute();

		String response = resp.body();		return parse(response);
	}


	private Map<String, String> parse(String nvp) {
		Map<String, String> map = new HashMap<>();
		for (String pair : nvp.split("&")) {
			String[] kv = pair.split("=");
			if (kv.length == 2) {
				map.put(kv[0], URLDecoder.decode(kv[1], StandardCharsets.UTF_8));
			}
		}
		return map;
	}
}
