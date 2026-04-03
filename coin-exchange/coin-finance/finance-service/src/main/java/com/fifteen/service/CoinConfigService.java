package com.fifteen.service;

import com.fifteen.domain.CoinConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【coin_config(币种配置信息)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface CoinConfigService extends IService<CoinConfig> {

    CoinConfig findByCoinId(Long coinId);

    /**
     * 新增或修改币种配置
     * @param coinConfig
     * @return
     */
    boolean updateOrSave(CoinConfig coinConfig);
}
