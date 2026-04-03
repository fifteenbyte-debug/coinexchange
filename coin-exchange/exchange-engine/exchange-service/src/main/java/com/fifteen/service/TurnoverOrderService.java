package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.TurnoverOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【turnover_order(成交订单)】的数据库操作Service
* @createDate 2026-03-26 17:43:15
*/
public interface TurnoverOrderService extends IService<TurnoverOrder> {

    Page<TurnoverOrder> findByPage(Page<TurnoverOrder> page, Long userId, String symbol, Integer type);

    List<TurnoverOrder> getBuyTurnoverOrder(Long id, Long userId);

    List<TurnoverOrder> getSellTurnoverOrder(Long id, Long userId);

    List<TurnoverOrder> findBySymbol(String symbol);
}
