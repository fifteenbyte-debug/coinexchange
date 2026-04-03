package com.fifteen.rocket;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

    @Input("order_in")
    public SubscribableChannel messageChannel() ;
}
