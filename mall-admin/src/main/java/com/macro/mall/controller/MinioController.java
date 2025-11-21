package com.macro.mall.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.BucketPolicyConfigDto;
import com.macro.mall.dto.MinioUploadDto;
import com.macro.mall.manager.MinioServiceManage;
import io.minio.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MinIO对象存储管理Controller
 * Created by macro on 2019/12/25.
 */
@RestController
@Api(tags = "MinioController")
@Tag(name = "MinioController", description = "MinIO对象存储管理")
@RequestMapping("/image/minio")
public class MinioController {

    @Autowired
    private MinioServiceManage minioServiceManage;

    @PostMapping("/upload")
    public CommonResult<String> upload(@RequestPart("file") MultipartFile file) {
        return CommonResult.success(minioServiceManage.uploadImage(file));
    }
}
