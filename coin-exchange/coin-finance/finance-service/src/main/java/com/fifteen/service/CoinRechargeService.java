package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.CoinRecharge;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【coin_recharge(数字货币充值记录)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface CoinRechargeService extends IService<CoinRecharge> {

    Page<CoinRecharge> findByPage(Page<CoinRecharge> page, Long coinId, Long userId, String userName, String mobile, Byte status, String numMin, String numMax, String startTime, String endTime);
}
