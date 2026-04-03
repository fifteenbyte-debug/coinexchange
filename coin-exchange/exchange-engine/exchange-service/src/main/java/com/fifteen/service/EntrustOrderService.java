package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.EntrustOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.domain.ExchangeTrade;
import com.fifteen.param.OrderParam;
import com.fifteen.vo.TradeEntrustOrderVo;

/**
* @author msc
* @description 针对表【entrust_order(委托订单信息)】的数据库操作Service
* @createDate 2026-03-26 17:43:15
*/
public interface EntrustOrderService extends IService<EntrustOrder> {

    Page<EntrustOrder> findByPage(Page<EntrustOrder> page, Long userId, String symbol, Integer type);


    Page<TradeEntrustOrderVo> getHistoryEntrustOrder(Page<EntrustOrder> page, String symbol, Long userId);

    Page<TradeEntrustOrderVo> getEntrustOrder(Page<EntrustOrder> page, String symbol, Long userId);

    Boolean createEntrustOrder(Long userId, OrderParam orderParam);

    void cancleEntrustOrder(Long orderId);

    void doMatch(ExchangeTrade exchangeTrade);

    void cancleEntrustOrderToDb(String orderId);
}
