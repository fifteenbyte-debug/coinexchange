package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.AccountDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.domain.CoinWithdraw;

/**
* @author msc
* @description 针对表【account_detail(资金账户流水)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface AccountDetailService extends IService<AccountDetail> {

    Page<AccountDetail> findByPage(Page<AccountDetail> page, Long accountId,Long coinId,Long userId, String userName, String mobile, String amountStart, String amountEnd, String startTime, String endTime);
}
