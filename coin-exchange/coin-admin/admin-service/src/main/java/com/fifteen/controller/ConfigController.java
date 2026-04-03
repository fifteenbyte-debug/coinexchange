package com.fifteen.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.Config;
import com.fifteen.model.R;
import com.fifteen.service.ConfigService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping
    @ApiOperation("分页查询后台参数")
    @PreAuthorize("hasAnyAuthority('config_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "参数类型", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "参数代码", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "参数名称", dataType = "String")}
    )
    public R<Page> findByPage(@ApiIgnore Page<Config> page, String type, String code, String name) {
        return R.ok(configService.findByPage(page, type, code, name));
    }

    @PostMapping
    @ApiOperation("添加参数")
    @PreAuthorize("hasAnyAuthority('config_create')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "参数信息", required = true, dataType = "Config")
    })
    public R add(@RequestBody @Validated Config config) {
        return configService.save(config) ? R.ok() : R.fail("新增参数失败");
    }

    @PatchMapping
    @ApiOperation("修改参数")
    @PreAuthorize("hasAnyAuthority('config_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "参数信息", required = true, dataType = "Config")
    })
    public R update(@RequestBody @Validated Config config) {
        return configService.updateById(config) ? R.ok() : R.fail("修改参数失败");
    }


}
