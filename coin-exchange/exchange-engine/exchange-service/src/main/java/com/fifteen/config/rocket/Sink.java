package com.fifteen.config.rocket;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Sink {

    @Input("exchange_trade_in")
    MessageChannel exchangeTradeIn();

    /**
     * 取消订单的输入
     * @return
     */
    @Input("cancel_order_in")
    MessageChannel cancelOrderIn() ;
}
