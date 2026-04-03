package com.fifteen.controller;

import com.fifteen.domain.Sms;
import com.fifteen.model.R;
import com.fifteen.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@Api("短信服务")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @RequestMapping("/sendTo")
    @ApiOperation(value = "发送短信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sms", value = "sms的json数据")
    })
    public R sendSms(@RequestBody @Validated Sms sms) {
        boolean isOk = smsService.sendSms(sms);
        return isOk ? R.ok() : R.fail("发送失败");
    }
}
