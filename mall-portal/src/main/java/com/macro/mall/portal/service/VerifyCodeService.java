package com.macro.mall.portal.service;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VerifyCodeService {

	@Autowired
	private StringRedisTemplate redisTemplate;

	private static final String KEY_PREFIX = "verify_code:";

	public void saveCode(String email, String code) {
		redisTemplate.opsForValue().set(
			KEY_PREFIX + email,
			code,
			5, TimeUnit.MINUTES // 5分钟有效期
		);
	}

	public boolean validate(String email, String code) {
		String realCode = redisTemplate.opsForValue().get(KEY_PREFIX + email);
		return code.equals(realCode);
	}

}
