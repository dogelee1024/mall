package com.macro.mall.portal.service;

import com.macro.mall.portal.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthCodeSender {

	@Autowired
	private MailService mailService;
	@Autowired
	private UmsMemberCacheService umsMemberCacheService;

	@Autowired
	private VerifyCodeService verifyCodeService;

	public void sendRegisterCode(String email) {
		String code = VerifyCodeUtil.generateCode(6);
		//verifyCodeService.saveCode(email, code);
		umsMemberCacheService.setAuthCode(email, code);

		String content = "您的注册验证码为：" + code + "，有效期5分钟。";

		mailService.sendSimpleMail(email, "注册验证码", content);
	}

	public void sendLoginCode(String email) {
		String code = VerifyCodeUtil.generateCode(6);
		//verifyCodeService.saveCode(email, code);
		umsMemberCacheService.setAuthCode(email, code);

		String content = "您的登录验证码为：" + code + "，有效期5分钟。";

		mailService.sendSimpleMail(email, "登录验证码", content);
	}
}
