package com.fifteen.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.AdminBank;
import com.fifteen.dto.AdminBankDto;
import com.fifteen.feign.AdminBankServiceFeign;
import com.fifteen.model.R;
import com.fifteen.service.AdminBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/adminBanks")
@Api("公司银行卡管理")
public class AdminBankController implements AdminBankServiceFeign {

    @Autowired
    private AdminBankService adminBankService;

    @GetMapping
    @ApiOperation("分页查询公司银行卡")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "bankCard", value = "银行卡号", dataType = "String", paramType = "query")}
    )
    public R<Page> findByPage(@ApiIgnore Page<AdminBank> page, String bankCard) {
        Page<AdminBank> adminBankPage = adminBankService.findByPage(page, bankCard);
        return R.ok(adminBankPage);
    }

    @PostMapping
    @ApiOperation("添加银行卡")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminBank", value = "银行卡信息", required = true, dataType = "AdminBank", paramType = "body")
    })

    public R add(@RequestBody @Validated AdminBank adminBank) {
        boolean save = adminBankService.save(adminBank);
        return save ? R.ok() : R.fail("新增银行卡失败");
    }

    @PatchMapping
    @ApiOperation("修改银行卡")
    @PreAuthorize("hasAnyAuthority('admin_bank_update')")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminBank", value = "银行卡信息", required = true, dataType = "AdminBank", paramType = "body")})
    public R update(@RequestBody @Validated AdminBank adminBank) {
        boolean update = adminBankService.updateById(adminBank);
        return update ? R.ok() : R.fail("修改银行卡失败");
    }

    @PostMapping("/adminUpdateBankStatus")
    @ApiOperation("修改银行卡状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bankId", value = "银行卡id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "银行卡状态", required = true, dataType = "Integer", paramType = "query")})
    public R changeStatus(Long bankId, Integer status) {
        AdminBank adminBank = new AdminBank();
        adminBank.setId(bankId);
        adminBank.setStatus(status);
        boolean update = adminBankService.updateById(adminBank);
        return update ? R.ok() : R.fail("修改银行卡状态失败");
    }

    @Override
    public List<AdminBankDto> getAllAdminBanks() {
        List<AdminBankDto> adminBankDtos = adminBankService.getAllAdminBanks();
        return adminBankDtos;
    }
}