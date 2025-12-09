package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.model.RequestSendEmailVO;
import com.macro.mall.portal.service.AuthCodeSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public CommonResult<String> sendRegisterCode(@RequestBody RequestSendEmailVO email) {
		authCodeSender.sendRegisterCode(email.getEmail());
		return CommonResult.success("send code success");
	}

	@PostMapping("/login/sendCode")
	@ApiOperation("登录验证码")
	public CommonResult<String> sendLoginCode(@RequestBody RequestSendEmailVO email) {
		authCodeSender.sendLoginCode(email.getEmail());
		return CommonResult.success("send code success");
	}
}
