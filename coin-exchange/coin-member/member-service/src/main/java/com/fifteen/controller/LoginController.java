package com.fifteen.controller;

import com.fifteen.model.LoginForm;
import com.fifteen.model.LoginUser;
import com.fifteen.model.R;
import com.fifteen.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("用户登录")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "会员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginForm", value = "登录的表单参数", required = true),
    })
    public R<LoginUser> login(@RequestBody @Validated LoginForm loginForm){
        LoginUser loginUser = loginService.login(loginForm);
        return R.ok(loginUser);
    }

}
