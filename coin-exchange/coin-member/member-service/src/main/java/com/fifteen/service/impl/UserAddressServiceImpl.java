package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.UserAddress;
import com.fifteen.service.UserAddressService;
import com.fifteen.mapper.UserAddressMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author msc
 * @description 针对表【user_address(用户钱包地址信息)】的数据库操作Service实现
 * @createDate 2026-03-17 17:38:19
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress>
        implements UserAddressService {

    @Override
    public Page<UserAddress> findByPage(Page<UserAddress> page, Long userId) {
        return page(page, new LambdaQueryWrapper<UserAddress>().eq(UserAddress::getUserId, userId));
    }

    /**
     * 获取用户的提供地址
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getUserAddressByUserId(Long userId) {
        return list(new LambdaQueryWrapper<UserAddress>().eq(UserAddress::getUserId, userId).orderByDesc(UserAddress::getCreated));
    }


    /**
     * 使用用户的Id 和币种的Id 查询用户的充币地址
     *
     * @param userId
     * @param coinId
     * @return
     */
    @Override
    public UserAddress getUserAddressByUserIdAndCoinId(String userId, Long coinId) {
        return getOne(new LambdaQueryWrapper<UserAddress>()
                .eq(UserAddress::getUserId, userId)
                .eq(UserAddress::getCoinId, coinId)
        );
    }
}




