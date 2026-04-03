package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.Coin;
import com.fifteen.domain.Config;
import com.fifteen.service.ConfigService;
import com.fifteen.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

/**
 * @author msc
 * @description 针对表【config(平台配置信息)】的数据库操作Service实现
 * @createDate 2026-03-25 17:06:55
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config>
        implements ConfigService {

    @Override
    public Config getConfigByCode(String code) {
        return getOne(new LambdaQueryWrapper<Config>().eq(Config::getCode, code));
    }
}




