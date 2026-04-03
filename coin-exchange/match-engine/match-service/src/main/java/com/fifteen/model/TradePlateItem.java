package com.fifteen.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TradePlateItem {

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private BigDecimal amount;
}
