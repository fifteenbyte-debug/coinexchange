package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.MarketDto;
import com.fifteen.domain.Market;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
* @author msc
* @description 针对表【market(交易对配置信息)】的数据库操作Service
* @createDate 2026-03-26 17:43:15
*/
public interface MarketService extends IService<Market> {

    Page<Market> findByPage(Page<Market> page, Long tradeAreaId, Byte status);

    List<Market> getMarkersByTradeAreaId(Long id);

    Market getMarkerBySymbol(@NotNull String symbol);

    MarketDto findByCoinId(Long buyCoinId, Long sellCoinId);

    List<MarketDto> queryAllMarkets();
}
