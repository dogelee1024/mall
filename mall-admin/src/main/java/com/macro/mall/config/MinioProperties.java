package com.macro.mall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Data
@Configuration
@Primary
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
	private String endpoint;
	private String accessKey;
	private String secretKey;
	private String bucket;
}