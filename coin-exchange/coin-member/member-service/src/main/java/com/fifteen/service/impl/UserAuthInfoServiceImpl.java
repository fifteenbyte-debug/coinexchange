package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.UserAuthInfo;
import com.fifteen.service.UserAuthInfoService;
import com.fifteen.mapper.UserAuthInfoMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author msc
 * @description 针对表【user_auth_info(实名认证信息)】的数据库操作Service实现
 * @createDate 2026-03-17 17:38:19
 */
@Service
public class UserAuthInfoServiceImpl extends ServiceImpl<UserAuthInfoMapper, UserAuthInfo>
        implements UserAuthInfoService {

    @Override
    public List<UserAuthInfo> getUserAuthInfoByCode(Long authCode) {
        return list(new LambdaQueryWrapper<UserAuthInfo>().eq(UserAuthInfo::getAuthCode, authCode));
    }

    @Override
    public List<UserAuthInfo> getUserAuthInfoByUserId(Long id) {
        return list(new LambdaQueryWrapper<UserAuthInfo>().eq(UserAuthInfo::getUserId, id));
    }
}




