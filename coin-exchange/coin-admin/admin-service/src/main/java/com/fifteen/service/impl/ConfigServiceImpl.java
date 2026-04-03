package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.Config;
import com.fifteen.service.ConfigService;
import com.fifteen.mapper.ConfigMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author msc
 * @description 针对表【config(平台配置信息)】的数据库操作Service实现
 * @createDate 2026-03-12 17:29:37
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config>
        implements ConfigService {

    @Override
    public Page findByPage(Page<Config> page, String type, String code, String name) {
        return page(page,new LambdaQueryWrapper<Config>()
                .like(StringUtils.isNotBlank(type), Config::getType, type)
                .like(StringUtils.isNotBlank(code), Config::getCode, code)
                .like(StringUtils.isNotBlank(name), Config::getName, name)
        );
    }
}




