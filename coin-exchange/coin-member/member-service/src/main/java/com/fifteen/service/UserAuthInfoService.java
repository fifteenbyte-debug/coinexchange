package com.fifteen.service;

import com.fifteen.domain.UserAuthInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【user_auth_info(实名认证信息)】的数据库操作Service
* @createDate 2026-03-17 17:38:19
*/
public interface UserAuthInfoService extends IService<UserAuthInfo> {

    /**
     * 根据认证码获取认证信息
     * @param authCode
     * @return
     */
    List<UserAuthInfo> getUserAuthInfoByCode(Long authCode);

    List<UserAuthInfo> getUserAuthInfoByUserId(Long id);
}
