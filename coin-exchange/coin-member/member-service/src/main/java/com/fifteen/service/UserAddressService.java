package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【user_address(用户钱包地址信息)】的数据库操作Service
* @createDate 2026-03-17 17:38:19
*/
public interface UserAddressService extends IService<UserAddress> {

    Page<UserAddress> findByPage(Page<UserAddress> page, Long userId);

    List<UserAddress> getUserAddressByUserId(Long aLong);

    UserAddress getUserAddressByUserIdAndCoinId(String userId, Long coinId);
}
