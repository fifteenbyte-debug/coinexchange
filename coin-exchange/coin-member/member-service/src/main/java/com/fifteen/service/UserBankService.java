package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.UserBank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【user_bank(用户人民币提现地址)】的数据库操作Service
* @createDate 2026-03-17 17:38:19
*/
public interface UserBankService extends IService<UserBank> {

    Page<UserBank> findByPage(Page<UserBank> page, Long userId);

    UserBank getCurrentUserBank(Long userId);

    boolean bindBank(UserBank userBank);
}
