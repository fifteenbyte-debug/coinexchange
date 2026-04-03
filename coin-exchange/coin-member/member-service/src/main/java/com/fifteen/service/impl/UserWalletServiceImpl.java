package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.User;
import com.fifteen.domain.UserWallet;
import com.fifteen.service.UserService;
import com.fifteen.service.UserWalletService;
import com.fifteen.mapper.UserWalletMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author msc
 * @description 针对表【user_wallet(用户提币地址)】的数据库操作Service实现
 * @createDate 2026-03-17 17:38:19
 */
@Service
public class UserWalletServiceImpl extends ServiceImpl<UserWalletMapper, UserWallet>
        implements UserWalletService {

    @Autowired
    private UserService userService ;
    @Override
    public Page<UserWallet> findByPage(Page<UserWallet> page, Long userId) {
        return this.page(page, new LambdaQueryWrapper<UserWallet>().eq(UserWallet::getUserId, userId));
    }

    /**
     * 查询用户的提币的地址
     *
     * @param userId 用户的Id
     * @param coinId 币种的Id
     * @return
     */
    @Override
    public List<UserWallet> findUserWallets(Long userId, Long coinId) {
        return list(new LambdaQueryWrapper<UserWallet>()
                .eq(UserWallet::getUserId,userId)
                .eq(UserWallet::getCoinId,coinId)
        )   ;
    }

    @Override
    public boolean save(UserWallet entity) {
        Long userId = entity.getUserId();
        User user = userService.getById(userId);
        if(user==null){
            throw new IllegalArgumentException("该用户不存在") ;
        }
        String paypassword = user.getPaypassword();
        if(StringUtils.isEmpty(paypassword) ||  !(new BCryptPasswordEncoder().matches(entity.getPayPassword(),paypassword))){
            throw new IllegalArgumentException("交易密码错误") ;
        }
        return super.save(entity);
    }


    /**
     * 删除用户的提现地址
     *
     * @param addressId   提现地址的Id
     * @param payPassword 交易密码
     * @return
     */
    @Override
    public boolean deleteUserWallet(Long addressId, String payPassword) {
        UserWallet userWallet = getById(addressId);
        if(userWallet==null){
            throw new IllegalArgumentException("提现地址错误") ;
        }
        Long userId = userWallet.getUserId();
        User user = userService.getById(userId);
        if(user==null){
            throw new IllegalArgumentException("用户不存在") ;
        }
        String paypassword = user.getPaypassword();
        if(StringUtils.isEmpty(paypassword) ||  !(new BCryptPasswordEncoder().matches(payPassword,paypassword))){
            throw new IllegalArgumentException("交易密码错误") ;
        }
        return super.removeById(addressId);
    }
}




