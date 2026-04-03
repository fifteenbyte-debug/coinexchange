package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.WebConfig;
import com.fifteen.service.WebConfigService;
import com.fifteen.mapper.WebConfigMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author msc
* @description 针对表【web_config(网站配置信息)】的数据库操作Service实现
* @createDate 2026-03-12 17:29:37
*/
@Service
public class WebConfigServiceImpl extends ServiceImpl<WebConfigMapper, WebConfig>
    implements WebConfigService{

    @Override
    public Page<WebConfig> findByPage(Page<WebConfig> page, String name, String type) {
        return page(page,new LambdaQueryWrapper<WebConfig>()
                .like(StringUtils.isNotBlank(name),WebConfig::getName,name)
                .like(StringUtils.isNotBlank(type),WebConfig::getType,type)
        );
    }

    @Override
    public List<WebConfig> getPcBanners() {
        return list(new LambdaQueryWrapper<WebConfig>()
                .eq(WebConfig::getType,"WEB_BANNER")
                .eq(WebConfig::getStatus,1)
                .orderByAsc(WebConfig::getSort));
    }
}




