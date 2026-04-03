package com.fifteen.disruptor;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderEvent implements Serializable {

    /**
     * 时间戳
     */
    private final long timestamp;

    /**
     * 消息携带的数据
     */
    private transient Object source;

    public OrderEvent(){
        this.timestamp = System.currentTimeMillis();
    }

    public OrderEvent(long timestamp,Object source){
        this.timestamp = System.currentTimeMillis();
        this.source = source;
    }
}
