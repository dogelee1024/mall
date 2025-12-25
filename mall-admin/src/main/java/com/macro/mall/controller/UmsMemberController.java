package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.api.ResultCode;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberExample;
import com.macro.mall.model.UmsMenu;
import com.macro.mall.model.UmsMenuExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "UmsMemberController")
@Tag(name = "UmsMemberController", description = "会员管理")
@RequestMapping("/member")
public class UmsMemberController {

	@Autowired
	private UmsMemberMapper umsMemberMapper;

	@ApiOperation("会员列表")
	@GetMapping(value = "/list")
	@ResponseBody
	public CommonResult<CommonPage<UmsMember>> list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		UmsMemberExample example = new UmsMemberExample();
		example.setOrderByClause("create_time desc");
		List<UmsMember> umsMembers = umsMemberMapper.selectByExample(example);
		return CommonResult.success(CommonPage.restPage(umsMembers));
	}
}
