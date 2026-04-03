package com.fifteen.service;

import com.fifteen.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.vo.SymbolAssetVo;
import com.fifteen.vo.UserTotalAccountVo;

import java.math.BigDecimal;

/**
* @author msc
* @description 针对表【account(用户财产记录)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface AccountService extends IService<Account> {

    boolean transferAccountAmount(Long adminId, Long userId, Long coinId,Long orderNum, BigDecimal num, BigDecimal fee, String remark, String businessType, Integer direction);

    Boolean decreaseAccountAmount(Long adminId, Long userId, Long coinId, Long orderNum, BigDecimal num, BigDecimal fee, String remark, String businessType, Integer direction);

    Account findByUserAndCoin(Long userId, String coinName);

    /**
     * 暂时锁定用户的资产
     * @param userId
     *  用户的id
     * @param coinId
     * 币种的id
     * @param mum
     * 锁定的金额
     * @param type
     *      资金流水的类型
     * @param orderId
     *      订单的Id
     * @param fee
     *  本次操作的手续费
     */
    void lockUserAmount(Long userId, Long coinId, BigDecimal mum, String type, Long orderId, BigDecimal fee);

    UserTotalAccountVo getUserTotalAccount(Long userId);

    SymbolAssetVo getSymbolAssert(String symbol, Long userId);

    void transferBuyAmount(Long fromUserId, Long toUserId, Long coinId, BigDecimal amount, String businessType, Long orderId);

    void transferSellAmount(Long fromUserId, Long toUserId, Long coinId, BigDecimal amount, String businessType, Long orderId);
}
