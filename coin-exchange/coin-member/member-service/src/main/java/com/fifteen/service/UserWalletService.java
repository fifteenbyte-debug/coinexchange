package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.UserWallet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【user_wallet(用户提币地址)】的数据库操作Service
* @createDate 2026-03-17 17:38:19
*/
public interface UserWalletService extends IService<UserWallet> {

    Page<UserWallet> findByPage(Page<UserWallet> page, Long userId);

    /**
     * 查询用户的提币的地址
     * @param userId
     * 用户的Id
     * @param coinId
     * 币种的Id
     * @return
     */
    List<UserWallet> findUserWallets(Long userId, Long coinId);

    /**
     * 删除用户的提现地址
     * @param addressId
     *   提现地址的Id
     * @param payPassword
     * 交易密码
     * @return
     */
    boolean deleteUserWallet(Long addressId, String payPassword);
}
