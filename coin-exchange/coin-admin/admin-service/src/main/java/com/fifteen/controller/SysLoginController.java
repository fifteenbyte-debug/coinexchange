package com.fifteen.controller;

import com.fifteen.feign.OAuth2FeignClient;
import com.fifteen.model.LoginResult;
import com.fifteen.service.SysLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 */
@RestController
@Api(tags = "登录")
public class SysLoginController {


    @Autowired
    private SysLoginService sysLoginService;


    @PostMapping("/login")
    @ApiOperation("后台管理人员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    public LoginResult login(String username, String password) {
        return sysLoginService.login(username, password);
    }

}
