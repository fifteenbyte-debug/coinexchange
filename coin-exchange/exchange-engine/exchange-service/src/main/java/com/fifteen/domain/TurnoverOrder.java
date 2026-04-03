package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 成交订单
 * @TableName turnover_order
 */
@TableName(value ="turnover_order")
@Data
public class TurnoverOrder {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 市场ID
     */
    @TableField(value = "market_id")
    private Long marketId;

    /**
     * 交易对类型：1-币币交易；2-创新交易；
     */
    @TableField(value = "market_type")
    private Integer marketType;

    /**
     * 交易类型:1 买 2卖
     */
    @TableField(value = "trade_type")
    private Integer tradeType;

    /**
     * 交易对标识符
     */
    @TableField(value = "symbol")
    private String symbol;

    /**
     * 交易对名称
     */
    @TableField(value = "market_name")
    private String marketName;

    /**
     * 卖方用户ID
     */
    @TableField(value = "sell_user_id")
    private Long sellUserId;

    /**
     * 卖方币种ID
     */
    @TableField(value = "sell_coin_id")
    private Long sellCoinId;

    /**
     * 卖方委托订单ID
     */
    @TableField(value = "sell_order_id")
    private Long sellOrderId;

    /**
     * 卖方委托价格
     */
    @TableField(value = "sell_price")
    private BigDecimal sellPrice;

    /**
     * 卖方手续费率
     */
    @TableField(value = "sell_fee_rate")
    private BigDecimal sellFeeRate;

    /**
     * 卖方委托数量
     */
    @TableField(value = "sell_volume")
    private BigDecimal sellVolume;

    /**
     * 买方用户ID
     */
    @TableField(value = "buy_user_id")
    private Long buyUserId;

    /**
     * 买方币种ID
     */
    @TableField(value = "buy_coin_id")
    private Long buyCoinId;

    /**
     * 买方委托订单ID
     */
    @TableField(value = "buy_order_id")
    private Long buyOrderId;

    /**
     * 买方委托数量
     */
    @TableField(value = "buy_volume")
    private BigDecimal buyVolume;

    /**
     * 买方委托价格
     */
    @TableField(value = "buy_price")
    private BigDecimal buyPrice;

    /**
     * 买方手续费率
     */
    @TableField(value = "buy_fee_rate")
    private BigDecimal buyFeeRate;

    /**
     * 委托订单ID
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 成交总额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 成交价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 成交数量
     */
    @TableField(value = "volume")
    private BigDecimal volume;

    /**
     * 成交卖出手续费
     */
    @TableField(value = "deal_sell_fee")
    private BigDecimal dealSellFee;

    /**
     * 成交卖出手续费率
     */
    @TableField(value = "deal_sell_fee_rate")
    private BigDecimal dealSellFeeRate;

    /**
     * 成交买入手续费
     */
    @TableField(value = "deal_buy_fee")
    private BigDecimal dealBuyFee;

    /**
     * 成交买入成交率费
     */
    @TableField(value = "deal_buy_fee_rate")
    private BigDecimal dealBuyFeeRate;

    /**
     * 状态0待成交，1已成交，2撤销，3.异常
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 更新时间
     */
    @TableField(value = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created")
    private Date created;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TurnoverOrder other = (TurnoverOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getMarketType() == null ? other.getMarketType() == null : this.getMarketType().equals(other.getMarketType()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getSymbol() == null ? other.getSymbol() == null : this.getSymbol().equals(other.getSymbol()))
            && (this.getMarketName() == null ? other.getMarketName() == null : this.getMarketName().equals(other.getMarketName()))
            && (this.getSellUserId() == null ? other.getSellUserId() == null : this.getSellUserId().equals(other.getSellUserId()))
            && (this.getSellCoinId() == null ? other.getSellCoinId() == null : this.getSellCoinId().equals(other.getSellCoinId()))
            && (this.getSellOrderId() == null ? other.getSellOrderId() == null : this.getSellOrderId().equals(other.getSellOrderId()))
            && (this.getSellPrice() == null ? other.getSellPrice() == null : this.getSellPrice().equals(other.getSellPrice()))
            && (this.getSellFeeRate() == null ? other.getSellFeeRate() == null : this.getSellFeeRate().equals(other.getSellFeeRate()))
            && (this.getSellVolume() == null ? other.getSellVolume() == null : this.getSellVolume().equals(other.getSellVolume()))
            && (this.getBuyUserId() == null ? other.getBuyUserId() == null : this.getBuyUserId().equals(other.getBuyUserId()))
            && (this.getBuyCoinId() == null ? other.getBuyCoinId() == null : this.getBuyCoinId().equals(other.getBuyCoinId()))
            && (this.getBuyOrderId() == null ? other.getBuyOrderId() == null : this.getBuyOrderId().equals(other.getBuyOrderId()))
            && (this.getBuyVolume() == null ? other.getBuyVolume() == null : this.getBuyVolume().equals(other.getBuyVolume()))
            && (this.getBuyPrice() == null ? other.getBuyPrice() == null : this.getBuyPrice().equals(other.getBuyPrice()))
            && (this.getBuyFeeRate() == null ? other.getBuyFeeRate() == null : this.getBuyFeeRate().equals(other.getBuyFeeRate()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getDealSellFee() == null ? other.getDealSellFee() == null : this.getDealSellFee().equals(other.getDealSellFee()))
            && (this.getDealSellFeeRate() == null ? other.getDealSellFeeRate() == null : this.getDealSellFeeRate().equals(other.getDealSellFeeRate()))
            && (this.getDealBuyFee() == null ? other.getDealBuyFee() == null : this.getDealBuyFee().equals(other.getDealBuyFee()))
            && (this.getDealBuyFeeRate() == null ? other.getDealBuyFeeRate() == null : this.getDealBuyFeeRate().equals(other.getDealBuyFeeRate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMarketId() == null) ? 0 : getMarketId().hashCode());
        result = prime * result + ((getMarketType() == null) ? 0 : getMarketType().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
        result = prime * result + ((getMarketName() == null) ? 0 : getMarketName().hashCode());
        result = prime * result + ((getSellUserId() == null) ? 0 : getSellUserId().hashCode());
        result = prime * result + ((getSellCoinId() == null) ? 0 : getSellCoinId().hashCode());
        result = prime * result + ((getSellOrderId() == null) ? 0 : getSellOrderId().hashCode());
        result = prime * result + ((getSellPrice() == null) ? 0 : getSellPrice().hashCode());
        result = prime * result + ((getSellFeeRate() == null) ? 0 : getSellFeeRate().hashCode());
        result = prime * result + ((getSellVolume() == null) ? 0 : getSellVolume().hashCode());
        result = prime * result + ((getBuyUserId() == null) ? 0 : getBuyUserId().hashCode());
        result = prime * result + ((getBuyCoinId() == null) ? 0 : getBuyCoinId().hashCode());
        result = prime * result + ((getBuyOrderId() == null) ? 0 : getBuyOrderId().hashCode());
        result = prime * result + ((getBuyVolume() == null) ? 0 : getBuyVolume().hashCode());
        result = prime * result + ((getBuyPrice() == null) ? 0 : getBuyPrice().hashCode());
        result = prime * result + ((getBuyFeeRate() == null) ? 0 : getBuyFeeRate().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getDealSellFee() == null) ? 0 : getDealSellFee().hashCode());
        result = prime * result + ((getDealSellFeeRate() == null) ? 0 : getDealSellFeeRate().hashCode());
        result = prime * result + ((getDealBuyFee() == null) ? 0 : getDealBuyFee().hashCode());
        result = prime * result + ((getDealBuyFeeRate() == null) ? 0 : getDealBuyFeeRate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", marketId=").append(marketId);
        sb.append(", marketType=").append(marketType);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", symbol=").append(symbol);
        sb.append(", marketName=").append(marketName);
        sb.append(", sellUserId=").append(sellUserId);
        sb.append(", sellCoinId=").append(sellCoinId);
        sb.append(", sellOrderId=").append(sellOrderId);
        sb.append(", sellPrice=").append(sellPrice);
        sb.append(", sellFeeRate=").append(sellFeeRate);
        sb.append(", sellVolume=").append(sellVolume);
        sb.append(", buyUserId=").append(buyUserId);
        sb.append(", buyCoinId=").append(buyCoinId);
        sb.append(", buyOrderId=").append(buyOrderId);
        sb.append(", buyVolume=").append(buyVolume);
        sb.append(", buyPrice=").append(buyPrice);
        sb.append(", buyFeeRate=").append(buyFeeRate);
        sb.append(", orderId=").append(orderId);
        sb.append(", amount=").append(amount);
        sb.append(", price=").append(price);
        sb.append(", volume=").append(volume);
        sb.append(", dealSellFee=").append(dealSellFee);
        sb.append(", dealSellFeeRate=").append(dealSellFeeRate);
        sb.append(", dealBuyFee=").append(dealBuyFee);
        sb.append(", dealBuyFeeRate=").append(dealBuyFeeRate);
        sb.append(", status=").append(status);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}