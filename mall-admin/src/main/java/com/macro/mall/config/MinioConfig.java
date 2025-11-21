package com.macro.mall.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfig {

	@Bean
	public MinioClient minioClient(@Qualifier("minio-com.macro.mall.config.MinioProperties") MinioProperties properties) {
		return MinioClient.builder()
			.endpoint(properties.getEndpoint())
			.credentials(properties.getAccessKey(), properties.getSecretKey())
			.build();
	}
}
