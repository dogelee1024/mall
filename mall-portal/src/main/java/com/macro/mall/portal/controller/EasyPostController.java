package com.macro.mall.portal.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.api.IErrorCode;
import com.macro.mall.common.api.ResultCode;
import com.macro.mall.portal.model.TrackerBo;
import com.macro.mall.portal.model.TrackerResponse;
import com.macro.mall.portal.service.EasePostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "EasyPostController")
@Tag(name = "EasyPostController", description = "快递查询")
@RequestMapping("/post")
public class EasyPostController {

	@Autowired
	EasePostService easePostService;

	@ApiOperation("根据单号查询")
	@GetMapping(value = "/query/{trackNumer}")
	@ResponseBody
	public CommonResult query(@PathVariable String trackNumer) {
		if(StringUtils.isEmpty(trackNumer)){
			return CommonResult.failed(ResultCode.VALIDATE_FAILED);
		}
		TrackerBo trackerBo = new TrackerBo();
		trackerBo.setTrackingCode(trackNumer);
		TrackerResponse tracker = easePostService.createTracker(JSONObject.toJSONString(trackerBo));
		if(tracker == null){
			return CommonResult.failed("查询失败");
		}
		return CommonResult.success(tracker);
	}

}
