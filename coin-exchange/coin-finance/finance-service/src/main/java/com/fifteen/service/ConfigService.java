package com.fifteen.service;

import com.fifteen.domain.Coin;
import com.fifteen.domain.Config;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【config(平台配置信息)】的数据库操作Service
* @createDate 2026-03-25 17:06:55
*/
public interface ConfigService extends IService<Config> {

    /**
     * 使用货币的名称来查询货币
     * @param code
     * @return
     */
    Config getConfigByCode(String code);
}
