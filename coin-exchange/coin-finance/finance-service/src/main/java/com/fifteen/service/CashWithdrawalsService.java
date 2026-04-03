package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.CashWithdrawAuditRecord;
import com.fifteen.domain.CashWithdrawals;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.model.CashSellParam;

/**
* @author msc
* @description 针对表【cash_withdrawals(提现表)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface CashWithdrawalsService extends IService<CashWithdrawals> {

    /**
     * 提现记录查询
     * @param page
     * @param userId
     * @param userName
     * @param mobile
     * @param status
     * @param numMin
     * @param numMax
     * @param startTime
     * @param endTime
     * @return
     */
    Page<CashWithdrawals> findByPage(Page<CashWithdrawals> page, Long userId, String userName, String mobile, Byte status, String numMin, String numMax, String startTime, String endTime);

    boolean updateWithdrawalsStatus(Long userId, CashWithdrawAuditRecord cashWithdrawAuditRecord);

    Page<CashWithdrawals> findUserCashRecharge(Page<CashWithdrawals> page, Long userId, Integer status);

    boolean sell(Long userId, CashSellParam cashSellParam);
}
