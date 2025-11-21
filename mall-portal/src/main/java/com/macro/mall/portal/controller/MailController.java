package com.macro.mall.portal.controller;

import com.macro.mall.portal.service.AuthCodeSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "MailController")
@Tag(name = "MailController", description = "邮件管理")
@RequestMapping("/auth/mail")
public class MailController {
	@Autowired
	private AuthCodeSender authCodeSender;

	@PostMapping("/register/sendCode")
	@ApiOperation("注册验证码")
	public String sendRegisterCode(@RequestParam String email) {
		authCodeSender.sendRegisterCode(email);
		return "验证码已发送";
	}

	@PostMapping("/login/sendCode")
	@ApiOperation("登录验证码")
	public String sendLoginCode(@RequestParam String email) {
		authCodeSender.sendLoginCode(email);
		return "验证码已发送";
	}
}
