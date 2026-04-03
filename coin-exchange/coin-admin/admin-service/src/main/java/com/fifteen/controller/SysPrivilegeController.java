package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.SysPrivilege;
import com.fifteen.model.R;
import com.fifteen.service.SysPrivilegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@RestController
@RequestMapping("/privileges")
@Api(value = "权限管理")
public class SysPrivilegeController {

    @Autowired
    private SysPrivilegeService sysPrivilegeService;


    /**
     * 分页查询权限列表
     *
     * @param page
     * @return
     */
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", required = true, dataType = "int", paramType = "query")
    })
    @PreAuthorize("hasAuthority('sys_privilege_query')")
    public R<Page<SysPrivilege>> findByPage(@ApiIgnore Page<SysPrivilege> page) {
        //把最近修改的数据优先展示
        page.addOrder(OrderItem.desc("last_update_time"));
        Page<SysPrivilege> sysPrivilegePage = sysPrivilegeService.page(page);
        return R.ok(sysPrivilegePage);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sys_privilege_create')")
    @ApiOperation("添加权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPrivilege", value = "sysPrivilege的json数据", required = true)
    })
    public R add(@RequestBody @Validated SysPrivilege sysPrivilege) {
        boolean save = sysPrivilegeService.save(sysPrivilege);
        if (!save) {
            return R.fail("添加权限失败");
        }
        return R.ok("添加权限成功");
    }

    @PatchMapping
    @PreAuthorize("hasAuthority('sys_privilege_update')")
    @ApiOperation("修改权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPrivilege", value = "sysPrivilege的json数据", required = true)
    })
    public R update(@RequestBody @Validated SysPrivilege sysPrivilege) {
        boolean update = sysPrivilegeService.updateById(sysPrivilege);
        if (!update) {
            return R.fail("修改权限失败");
        }
        return R.ok("修改权限成功");
    }


}
