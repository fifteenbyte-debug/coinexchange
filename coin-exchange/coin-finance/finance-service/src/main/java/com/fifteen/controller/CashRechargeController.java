package com.fifteen.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.CashRecharge;
import com.fifteen.domain.CashRechargeAuditRecord;
import com.fifteen.model.CashParam;
import com.fifteen.model.R;
import com.fifteen.service.CashRechargeService;
import com.fifteen.util.ReportCsvUtils;
import com.fifteen.vo.CashTradeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@Api(tags = "GCN充值控制器")
public class CashRechargeController {

    @Autowired
    private CashRechargeService cashRechargeService;

    @GetMapping("/cashRecharges/records")
    @ApiOperation(value = "条件分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数"),
            @ApiImplicitParam(name = "coinId", value = "币种的Id"),
            @ApiImplicitParam(name = "userId", value = "用户的Id"),
            @ApiImplicitParam(name = "userName", value = "用户的名称"),
            @ApiImplicitParam(name = "mobile", value = "用户的手机号"),
            @ApiImplicitParam(name = "status", value = "充值审核状态"),
            @ApiImplicitParam(name = "numMin", value = "充值最小金额"),
            @ApiImplicitParam(name = "numMax", value = "充值最大金额"),
            @ApiImplicitParam(name = "startTime", value = "充值开始时间"),
            @ApiImplicitParam(name = "endTime", value = "充值结束时间"),

    })
    public R<Page<CashRecharge>> findByPage(
            @ApiIgnore Page<CashRecharge> page,
            Long coinId, Long userId, String userName,
            String mobile, Byte status, String numMin, String numMax,
            String startTime, String endTime
    ) {
        Page<CashRecharge> pageData = cashRechargeService.findByPage(page, coinId, userId, userName, mobile, status, numMin, numMax, startTime, endTime);
        return R.ok(pageData);
    }

    @PostMapping("/cashRecharge/cashRechargeUpdateStatus")
    @ApiOperation(value = "现金的充值审核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cashRechargeAuditRecord", value = "现金充值审核")
    })
    public R cashRechargeUpdateStatus(@RequestBody CashRechargeAuditRecord cashRechargeAuditRecord) {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        boolean isOk = cashRechargeService.cashRechargeAudit(userId, cashRechargeAuditRecord);
        return isOk ? R.ok() : R.fail("审核失败");
    }

    @GetMapping("/cashRecharges/user/records")
    @ApiOperation(value = "查询用户的充值记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数"),
            @ApiImplicitParam(name = "status", value = "充值审核状态")
    })
    public R<Page<CashRecharge>> findUserCashRecharge(@ApiIgnore Page<CashRecharge> page, Integer status) {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        Page<CashRecharge> pageData = cashRechargeService.findUserCashRecharge(page, userId, status);
        return R.ok(pageData);
    }

    @PostMapping("/cashRecharges/buy")
    @ApiOperation(value = "GCN充值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cashParam", value = "GCN充值参数")
    })
    public R<Object> buy(@RequestBody @Validated CashParam cashParam) {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        CashTradeVo cashTradeVo = cashRechargeService.buy(userId, cashParam);
        return R.ok(cashTradeVo);
    }
}
