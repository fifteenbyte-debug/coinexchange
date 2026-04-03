package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.Coin;
import com.fifteen.domain.CoinConfig;
import com.fifteen.service.CoinConfigService;
import com.fifteen.mapper.CoinConfigMapper;
import com.fifteen.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【coin_config(币种配置信息)】的数据库操作Service实现
* @createDate 2026-03-24 10:59:51
*/
@Service
public class CoinConfigServiceImpl extends ServiceImpl<CoinConfigMapper, CoinConfig>
    implements CoinConfigService{

    @Autowired
    private CoinService coinService;

    @Override
    public CoinConfig findByCoinId(Long coinId) {
        //coinConfig的id和Coin的id相同
        return getOne(new LambdaQueryWrapper<CoinConfig>().eq(CoinConfig::getId, coinId));
    }

    /**
     * 新增或修改币种配置
     *
     * @param coinConfig
     * @return
     */
    @Override
    public boolean updateOrSave(CoinConfig coinConfig) {

        Coin coin = coinService.getById(coinConfig.getId());
        if(coin==null){
            throw new IllegalArgumentException("coin-Id不存在") ;
        }
        coinConfig.setCoinType(coin.getType());
        coinConfig.setName(coin.getName());
        // 如何是新增/修改呢?
        CoinConfig config = getById(coinConfig.getId());
        if (config == null) { // 新增操作
            return save(coinConfig);
        } else { // 修改操作
            return updateById(coinConfig);
        }
    }
}




