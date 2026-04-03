package com.fifteen.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.AccountDetail;
import com.fifteen.domain.CoinWithdraw;
import com.fifteen.model.R;
import com.fifteen.service.AccountDetailService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/accountDetails")
public class AccountDetailController {

    @Autowired
    private AccountDetailService accountDetailService;

    @GetMapping("/records")
    @ApiOperation(value = "条件分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数"),
            @ApiImplicitParam(name = "accountId", value = "账号id"),
            @ApiImplicitParam(name = "coinId", value = "币种id"),
            @ApiImplicitParam(name = "userId", value = "用户的Id"),
            @ApiImplicitParam(name = "userName", value = "用户的名称"),
            @ApiImplicitParam(name = "mobile", value = "用户的手机号"),
            @ApiImplicitParam(name = "amountStart", value = "金额最小值"),
            @ApiImplicitParam(name = "amountEnd", value = "金额最大值"),
            @ApiImplicitParam(name = "startTime", value = "充值开始时间"),
            @ApiImplicitParam(name = "endTime", value = "充值结束时间"),

    })
    public R<Page<AccountDetail>> findByPage(@ApiIgnore Page<AccountDetail> page, Long accountId,Long coinId,Long userId, String userName, String mobile, String amountStart, String amountEnd, String startTime, String endTime) {
        Page<AccountDetail> pageData = accountDetailService.findByPage(page, accountId, coinId, userId, userName, mobile, amountStart, amountEnd, startTime, endTime);
        return R.ok(pageData);
    }
}
