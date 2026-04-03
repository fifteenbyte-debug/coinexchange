package com.fifteen.controller;

import com.fifteen.domain.CoinConfig;
import com.fifteen.model.R;
import com.fifteen.service.CoinConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coinConfigs")
@Api(tags = "币种配置信息管理")
public class CoinConfigController {

    @Autowired
    private CoinConfigService coinConfigService;

    @GetMapping("/info/{coinId}")
    @ApiOperation("获取币种配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "coinId", value = "币种ID")}
    )
    public R<CoinConfig> getCoinConfig(@PathVariable("coinId") Long coinId) {
        CoinConfig coinConfig = coinConfigService.findByCoinId(coinId);
        return R.ok(coinConfig);
    }

    @PatchMapping
    @ApiOperation(value = "币种配置的修改操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "coinConfig", value = "coinConfig的json数据")
    })
    public R update(@RequestBody @Validated CoinConfig coinConfig) {
        boolean saveOrUpdate = coinConfigService.updateOrSave(coinConfig);
        if (saveOrUpdate) {
            return R.ok();
        }
        return R.fail("修改失败");
    }
}
