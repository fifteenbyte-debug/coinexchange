package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.CashWithdrawals;
import com.fifteen.domain.CoinWithdraw;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【coin_withdraw(数字货币提现记录)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface CoinWithdrawService extends IService<CoinWithdraw> {

    Page<CoinWithdraw> findByPage(Page<CoinWithdraw> page, Long userId, String userName, String mobile, Byte status, String numMin, String numMax, String startTime, String endTime);
}
