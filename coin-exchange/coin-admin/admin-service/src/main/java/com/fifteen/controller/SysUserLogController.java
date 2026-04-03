package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.SysUserLog;
import com.fifteen.model.R;
import com.fifteen.service.SysUserLogService;
import com.fifteen.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/sysUserLog")
@Api(tags = "用户操作记录")
public class SysUserLogController {

    @Autowired
    private SysUserLogService sysUserLogService;

    @GetMapping
    @ApiOperation(value = "分页查询用户的操作记录")
    @ApiImplicitParam(name = "page", value = "分页参数")
    public R<Page<SysUserLog>> findByPage(@ApiIgnore Page<SysUserLog> page) {
        page.addOrder(OrderItem.desc("created"));
        return R.ok(sysUserLogService.page(page));
    }
}
