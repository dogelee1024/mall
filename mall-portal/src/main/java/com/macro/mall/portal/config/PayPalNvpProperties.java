package com.macro.mall.portal.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "paypal.nvp")
@Data
public class PayPalNvpProperties {

	private String mode;
	private String username;
	private String password;
	private String signature;

	private Endpoint endpoint = new Endpoint();

	@Data
	public static class Endpoint {
		private String sandbox;
		private String live;
	}

	public String getApiEndpoint() {
		return "live".equalsIgnoreCase(mode)
			? endpoint.getLive()
			: endpoint.getSandbox();
	}
}
