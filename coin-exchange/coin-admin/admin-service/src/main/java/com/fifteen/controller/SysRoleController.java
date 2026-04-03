package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.SysRole;
import com.fifteen.model.R;
import com.fifteen.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;

@RestController
@RequestMapping("/roles")
@Api("角色管理")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping
    @ApiOperation("分页查询")
    @PreAuthorize("hasAuthority('sys_role_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "角色名称", dataType = "string", paramType = "query")
    })
    public R<Page<SysRole>> findByPage(@ApiIgnore Page<SysRole> page, String name){
        page.addOrder(OrderItem.desc("last_update_time"));
        return R.ok(sysRoleService.findByPage(page, name));
    }

    @ApiOperation("添加角色")
    @PreAuthorize("hasAuthority('sys_role_create')")
    @PostMapping
    public R add(@RequestBody @Validated SysRole sysRole){
        boolean save = sysRoleService.save(sysRole);
        if (!save) {
            return R.fail("添加角色失败");
        }
        return R.ok("添加角色成功");
    }

    @ApiOperation("删除角色")
    @PreAuthorize("hasAuthority('sys_role_delete')")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "ids", value = "要删除角色的id集合", required = true, dataType = "string", paramType = "body")
    public R delete(@RequestBody String[] ids){
        if(ids==null||ids.length==0){
            return R.fail("请选择要删除的角色");
        }
        boolean removeById = sysRoleService.removeByIds(Arrays.asList(ids));
        if (!removeById) {
            return R.fail("删除角色失败");
        }
        return R.ok("删除角色成功");
    }
}
