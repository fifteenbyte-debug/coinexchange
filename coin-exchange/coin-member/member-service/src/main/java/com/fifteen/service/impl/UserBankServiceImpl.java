package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.User;
import com.fifteen.domain.UserBank;
import com.fifteen.service.UserBankService;
import com.fifteen.mapper.UserBankMapper;
import com.fifteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author msc
 * @description 针对表【user_bank(用户人民币提现地址)】的数据库操作Service实现
 * @createDate 2026-03-17 17:38:19
 */
@Service
public class UserBankServiceImpl extends ServiceImpl<UserBankMapper, UserBank>
        implements UserBankService {

    @Autowired
    private UserService userService;

    @Override
    public Page<UserBank> findByPage(Page<UserBank> page, Long userId) {
        return this.page(page, new LambdaQueryWrapper<UserBank>().eq(userId != null, UserBank::getUserId, userId));
    }

    @Override
    public UserBank getCurrentUserBank(Long userId) {
        return getOne(new LambdaQueryWrapper<UserBank>().
                eq(UserBank::getUserId, userId)
                .eq(UserBank::getStatus, 1)
        );
    }

    @Override
    public boolean bindBank(UserBank userBank) {
        String payPassword = userBank.getPayPassword();
        User user = userService.getById(userBank.getUserId());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(payPassword, user.getPaypassword())) {
            throw new IllegalArgumentException("请输入正确的支付密码");
        }
        Long id = userBank.getId();
        if (id != null && id > 0) {
            UserBank userBankDb = getById(id);
            if (userBankDb == null) {
                throw new IllegalArgumentException("用户银行卡不存在");
            }
            return updateById(userBank);
        }
        userBank.setStatus(1);
        return save(userBank);
    }
}




