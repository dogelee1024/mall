package com.macro.mall.portal.service;

import com.alibaba.fastjson.JSONObject;
import com.macro.mall.portal.model.TrackerResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EasePostService {

	@Value("${easy.post.key}")
	private String apiKey;

	public TrackerResponse createTracker(String param) {

		try {
			// 请求 Body（与 curl 完全一致）

			// Basic Auth 需要 base64(username:password)
			// EasyPost 使用 API_KEY 作为 username，password 留空
			String auth = apiKey + ":";
			String encodedAuth = Base64.getEncoder()
				.encodeToString(auth.getBytes(StandardCharsets.UTF_8));

			// 创建 HTTP 请求
			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.easypost.com/v2/trackers"))
				.header("Authorization", "Basic " + encodedAuth)
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(param))
				.build();

			// 发送请求
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			// 打印结果
			System.out.println("HTTP Status: " + response.statusCode());
			System.out.println("Response Body:\n" + response.body());
			if (response.statusCode() >= 200 && response.statusCode() < 300) { // 2xx 全部算成功
				return JSONObject.parseObject(response.body(), TrackerResponse.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

}
