package com.fifteen.controller;

import com.fifteen.domain.SysUser;
import com.fifteen.model.R;
import com.fifteen.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
public class TestController {

    @Autowired
    SysUserService sysUserService;

    @ApiOperation("获取用户信息")
    @GetMapping("/user/info/{id}")
    public R<SysUser> getSysUserInfo(@PathVariable("id") Long id) {
        SysUser sysUser = sysUserService.getById(id);
        return R.ok(sysUser);
    }
}
