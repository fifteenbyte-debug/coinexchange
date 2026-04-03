package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.TradeArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.vo.TradeAreaMarketVo;

import java.util.List;

/**
* @author msc
* @description 针对表【trade_area(交易区)】的数据库操作Service
* @createDate 2026-03-26 17:43:15
*/
public interface TradeAreaService extends IService<TradeArea> {

    Page<TradeArea> findByPage(Page<TradeArea> page, String name, Byte status);

    List<TradeArea> findAll(Byte status);

    List<TradeAreaMarketVo> findTradeAreaMarket();

    List<TradeAreaMarketVo> getUserFavoriteMarkets(Long userId);
}
