package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.AdminBank;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.dto.AdminBankDto;

import java.util.List;

/**
* @author msc
* @description 针对表【admin_bank(人民币充值卡号管理)】的数据库操作Service
* @createDate 2026-03-17 16:33:07
*/
public interface AdminBankService extends IService<AdminBank> {

    Page<AdminBank> findByPage(Page<AdminBank> page, String bankCard);

    List<AdminBankDto> getAllAdminBanks();
}
