package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.Config;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【config(平台配置信息)】的数据库操作Service
* @createDate 2026-03-12 17:29:37
*/
public interface ConfigService extends IService<Config> {

    Page findByPage(Page<Config> page, String type, String code, String name);
}
