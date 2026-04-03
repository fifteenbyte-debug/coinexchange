package com.fifteen.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.WebConfig;
import com.fifteen.model.R;
import com.fifteen.service.WebConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@Api(tags = "webConfig的控制器")
@RequestMapping("/webConfigs")
public class WebConfigController {

    @Autowired
    private WebConfigService webConfigService;

    @GetMapping
    @ApiOperation("分页查询webConfig")
    @PreAuthorize("hasAnyAuthority('web_config_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数"),
            @ApiImplicitParam(name = "name", value = "webConfig名称"),
            @ApiImplicitParam(name = "type", value = "webConfig类型")
    })
    public R<Page<WebConfig>> findByPage(@ApiIgnore Page<WebConfig> page, String name, String type) {
        Page<WebConfig> webConfigPage = webConfigService.findByPage(page, name, type);
        return R.ok(webConfigPage);
    }

    @PostMapping
    @ApiOperation("添加webConfig")
    @PreAuthorize("hasAnyAuthority('web_config_create')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "webConfig", value = "webConfig信息")
    })
    public R add(@RequestBody @Validated WebConfig webConfig) {
        boolean save = webConfigService.save(webConfig);
        return save ? R.ok() : R.fail("新增失败");
    }

    @PatchMapping
    @ApiOperation("修改webConfig")
    @PreAuthorize("hasAnyAuthority('web_config_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "webConfig", value = "webConfig信息")
    })
    public R update(@RequestBody @Validated WebConfig webConfig) {
        boolean update = webConfigService.updateById(webConfig);
        return update ? R.ok() : R.fail("修改失败");
    }


    @PostMapping("/delete")
    @ApiOperation("删除webConfig")
    @PreAuthorize("hasAnyAuthority('web_config_delete')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "id集合")
    })
    public R delete(@RequestBody String[] ids) {
        if (CollectionUtil.isEmpty(Arrays.asList(ids))) {
            return R.fail("请选择要删除的记录"); // Changed from Collections.isEmpty to Collections.isNotEmpty
        }
        boolean delete = webConfigService.removeByIds(Arrays.asList(ids));
        return delete ? R.ok() : R.fail("删除失败");
    }

    @GetMapping("/banners")
    @ApiOperation(value = "获取我们的pc端的banner图")
    public R<List<WebConfig>> banners(){
        List<WebConfig> banners = webConfigService.getPcBanners() ;
        return R.ok(banners) ;
    }
}
