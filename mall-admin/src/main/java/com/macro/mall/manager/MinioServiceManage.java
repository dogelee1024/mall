package com.macro.mall.manager;

import com.macro.mall.config.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MinioServiceManage {

	@Autowired
	private final MinioClient minioClient;

	@Autowired
	@Qualifier("minio-com.macro.mall.config.MinioProperties")
	private final MinioProperties properties;

	@PostConstruct
	public void initBucket() {
		try {
			boolean exists = minioClient.bucketExists(
				BucketExistsArgs.builder().bucket(properties.getBucket()).build()
			);
			if (!exists) {
				minioClient.makeBucket(
					MakeBucketArgs.builder().bucket(properties.getBucket()).build()
				);
			}
		} catch (Exception e) {
			throw new RuntimeException("MinIO bucket 初始化失败", e);
		}
	}

	/**
	 * 上传图片
	 */
	public String uploadImage(MultipartFile file) {
		try {
			String originalName = file.getOriginalFilename();
			String ext = Objects.requireNonNull(originalName)
				.substring(originalName.lastIndexOf("."));
			String objectName = UUID.randomUUID() + ext;

			minioClient.putObject(
				PutObjectArgs.builder()
					.bucket(properties.getBucket())
					.object(objectName)
					.stream(file.getInputStream(), file.getSize(), -1)
					.contentType(file.getContentType())
					.build()
			);

			// 返回可访问 URL
			return "http://amg.fengshuibest.com/" + properties.getBucket() + "/" + objectName;

		} catch (Exception e) {
			throw new RuntimeException("上传图片失败", e);
		}
	}
}
