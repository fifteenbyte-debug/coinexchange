package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.WebConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【web_config(网站配置信息)】的数据库操作Service
* @createDate 2026-03-12 17:29:37
*/
public interface WebConfigService extends IService<WebConfig> {

    Page<WebConfig> findByPage(Page<WebConfig> page, String name, String type);

    List<WebConfig> getPcBanners();
}
