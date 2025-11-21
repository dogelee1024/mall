package com.macro.mall.portal.util;

import java.util.Random;

public class VerifyCodeUtil {

	public static String generateCode(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10)); // 0-9
		}
		return sb.toString();
	}

}
