package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.UserBank;
import com.fifteen.dto.UserBankDto;
import com.fifteen.feign.UserBankServiceFeign;
import com.fifteen.mappers.UserBankDtoMapper;
import com.fifteen.model.R;
import com.fifteen.service.UserBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/userBanks")
@Api("用户银行卡管理")
public class UserBankController implements UserBankServiceFeign {

    @Autowired
    private UserBankService userBankService;

    @GetMapping
    @ApiOperation("分页查询用户银行卡")
    @PreAuthorize("hasAnyAuthority('user_bank_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "usrId", value = "用户id", required = true, dataType = "Long", paramType = "query")})
    public R<Page> findByPage(@ApiIgnore Page<UserBank> page, Long usrId) {
        page.addOrder(OrderItem.desc("last_update_time"));
        Page<UserBank> userBankPage = userBankService.findByPage(page, usrId);
        return R.ok(userBankPage);
    }

    @PostMapping("/status")
    @ApiOperation("更新用户银行卡状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户银行卡id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", required = true, dataType = "Integer", paramType = "query")})
    public R updateStatus(Long id, Integer status) {
        UserBank userBank = new UserBank();
        userBank.setId(id);
        userBank.setStatus(status);
        boolean b = userBankService.updateById(userBank);
        return b ? R.ok("银行卡状态更新成功") : R.fail("银行卡状态更新失败");
    }

    @PatchMapping
    @ApiOperation("更新用户银行卡")
    @ApiImplicitParam(name = "userBank", value = "银行卡信息", required = true, dataType = "UserBank", paramType = "body")
    public R update(@RequestBody @Validated UserBank userBank) {
        boolean b = userBankService.updateById(userBank);
        return b ? R.ok("银行卡更新成功") : R.fail("银行卡更新失败");
    }

    @GetMapping("/current")
    @ApiOperation("获取当前用户的银行卡")
    public R<UserBank> getCurrentUserBank() {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        UserBank userBank = userBankService.getCurrentUserBank(Long.valueOf(idStr));
        return R.ok(userBank);
    }

    @PostMapping("/bind")
    @ApiOperation("绑定银行卡")
    public R bind(@RequestBody @Validated UserBank userBank) {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        userBank.setUserId(Long.valueOf(idStr));
        boolean b = userBankService.bindBank(userBank);
        return b ? R.ok("银行卡绑定成功") : R.fail("银行卡绑定失败");
    }

    @Override
    public UserBankDto getUserBankInfo(Long userId) {
        UserBank currentUserBank = userBankService.getCurrentUserBank(userId);
        UserBankDto userBankDto = UserBankDtoMapper.INSTANCE.toConvertDto(currentUserBank);
        return userBankDto ;
    }
}
