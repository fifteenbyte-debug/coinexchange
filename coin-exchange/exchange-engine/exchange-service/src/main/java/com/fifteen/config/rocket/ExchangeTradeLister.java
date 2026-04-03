package com.fifteen.config.rocket;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.fifteen.domain.ExchangeTrade;
import com.fifteen.service.EntrustOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class ExchangeTradeLister {

    @Autowired
    private EntrustOrderService entrustOrderService;

    @Transactional
    @StreamListener("exchange_trade_in")
    public void receiveExchangeTrade(List<ExchangeTrade> exchangeTrades) {
        log.info("接收到交易记录:{}", JSON.toJSONString(exchangeTrades));
        if (CollectionUtil.isEmpty(exchangeTrades)) {
            return;
        }
        for (ExchangeTrade exchangeTrade : exchangeTrades) {
            if (exchangeTrade != null) {
                //  交易完成后,去更新我们的数据库
                entrustOrderService.doMatch(exchangeTrade);
            }
        }
    }


    /*@Transactional
    @StreamListener("order_in")*/
    public void receiveCancelOrder(String orderId) {
        log.info("接收到取消订单:{}", orderId);
        entrustOrderService.cancleEntrustOrderToDb(orderId);
    }
}
