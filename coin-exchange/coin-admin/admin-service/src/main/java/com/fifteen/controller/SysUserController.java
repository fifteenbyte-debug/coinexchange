package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.SysUser;
import com.fifteen.model.R;
import com.fifteen.service.SysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('sys_user_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "mobile", value = "员工手机号码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "fullname", value = "员工用户姓名", dataType = "String", paramType = "query")
    })
    public R<Page<SysUser>> list(@ApiIgnore Page<SysUser> page, String mobile, String fullname) {
        page.addOrder(OrderItem.desc("last_update_time"));
        return R.ok(sysUserService.findByPage(page, mobile, fullname));
    }

    @PostMapping
    @ApiOperation(value = "新增员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysUser", value = "sysUser的json数据")
    })
    public R addUser(@RequestBody SysUser sysUser) {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        sysUser.setCreateBy(userId);
        boolean isOk = sysUserService.addUser(sysUser);
        if (!isOk) {
            return R.fail("新增员工失败");
        }
        return R.ok();
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除员工")
    public R deleteUser(@RequestBody Long[] ids) {
        boolean b = sysUserService.removeByIds(Arrays.asList(ids));
        if(b){
            return R.ok();
        }
        return R.fail() ;
    }

}
