package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 委托订单信息
 * @TableName entrust_order
 */
@TableName(value ="entrust_order")
@Data
public class EntrustOrder {
    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 市场ID
     */
    @TableField(value = "market_id")
    private Long marketId;

    /**
     * 市场类型（1：币币交易，2：创新交易）
     */
    @TableField(value = "market_type")
    private Integer marketType;

    /**
     * 交易对标识符
     */
    @TableField(value = "symbol")
    private String symbol;

    /**
     * 交易市场
     */
    @TableField(value = "market_name")
    private String marketName;

    /**
     * 委托价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 合并深度价格1
     */
    @TableField(value = "merge_low_price")
    private BigDecimal mergeLowPrice;

    /**
     * 合并深度价格2
     */
    @TableField(value = "merge_high_price")
    private BigDecimal mergeHighPrice;

    /**
     * 委托数量
     */
    @TableField(value = "volume")
    private BigDecimal volume;

    /**
     * 委托总额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 手续费比率
     */
    @TableField(value = "fee_rate")
    private BigDecimal feeRate;

    /**
     * 交易手续费
     */
    @TableField(value = "fee")
    private BigDecimal fee;

    /**
     * 合约单位
     */
    @TableField(value = "contract_unit")
    private Integer contractUnit;

    /**
     * 成交数量
     */
    @TableField(value = "deal")
    private BigDecimal deal;

    /**
     * 冻结量
     */
    @TableField(value = "freeze")
    private BigDecimal freeze;

    /**
     * 保证金比例
     */
    @TableField(value = "margin_rate")
    private BigDecimal marginRate;

    /**
     * 基础货币对（USDT/BTC）兑换率
     */
    @TableField(value = "base_coin_rate")
    private BigDecimal baseCoinRate;

    /**
     * 报价货币对（USDT/BTC)兑换率
     */
    @TableField(value = "price_coin_rate")
    private BigDecimal priceCoinRate;

    /**
     * 占用保证金
     */
    @TableField(value = "lock_margin")
    private BigDecimal lockMargin;

    /**
     * 价格类型：1-市价；2-限价
     */
    @TableField(value = "price_type")
    private Integer priceType;

    /**
     * 交易类型：1-开仓；2-平仓
     */
    @TableField(value = "trade_type")
    private Integer tradeType;

    /**
     * 买卖类型：1-买入；2-卖出
2 卖出

     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 平仓委托关联单号
     */
    @TableField(value = "open_order_id")
    private Long openOrderId;

    /**
     * status
0未成交
1已成交
2已取消
4异常单
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
        EntrustOrder other = (EntrustOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getMarketType() == null ? other.getMarketType() == null : this.getMarketType().equals(other.getMarketType()))
            && (this.getSymbol() == null ? other.getSymbol() == null : this.getSymbol().equals(other.getSymbol()))
            && (this.getMarketName() == null ? other.getMarketName() == null : this.getMarketName().equals(other.getMarketName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMergeLowPrice() == null ? other.getMergeLowPrice() == null : this.getMergeLowPrice().equals(other.getMergeLowPrice()))
            && (this.getMergeHighPrice() == null ? other.getMergeHighPrice() == null : this.getMergeHighPrice().equals(other.getMergeHighPrice()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getFeeRate() == null ? other.getFeeRate() == null : this.getFeeRate().equals(other.getFeeRate()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getContractUnit() == null ? other.getContractUnit() == null : this.getContractUnit().equals(other.getContractUnit()))
            && (this.getDeal() == null ? other.getDeal() == null : this.getDeal().equals(other.getDeal()))
            && (this.getFreeze() == null ? other.getFreeze() == null : this.getFreeze().equals(other.getFreeze()))
            && (this.getMarginRate() == null ? other.getMarginRate() == null : this.getMarginRate().equals(other.getMarginRate()))
            && (this.getBaseCoinRate() == null ? other.getBaseCoinRate() == null : this.getBaseCoinRate().equals(other.getBaseCoinRate()))
            && (this.getPriceCoinRate() == null ? other.getPriceCoinRate() == null : this.getPriceCoinRate().equals(other.getPriceCoinRate()))
            && (this.getLockMargin() == null ? other.getLockMargin() == null : this.getLockMargin().equals(other.getLockMargin()))
            && (this.getPriceType() == null ? other.getPriceType() == null : this.getPriceType().equals(other.getPriceType()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getOpenOrderId() == null ? other.getOpenOrderId() == null : this.getOpenOrderId().equals(other.getOpenOrderId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMarketId() == null) ? 0 : getMarketId().hashCode());
        result = prime * result + ((getMarketType() == null) ? 0 : getMarketType().hashCode());
        result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
        result = prime * result + ((getMarketName() == null) ? 0 : getMarketName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMergeLowPrice() == null) ? 0 : getMergeLowPrice().hashCode());
        result = prime * result + ((getMergeHighPrice() == null) ? 0 : getMergeHighPrice().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getFeeRate() == null) ? 0 : getFeeRate().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getContractUnit() == null) ? 0 : getContractUnit().hashCode());
        result = prime * result + ((getDeal() == null) ? 0 : getDeal().hashCode());
        result = prime * result + ((getFreeze() == null) ? 0 : getFreeze().hashCode());
        result = prime * result + ((getMarginRate() == null) ? 0 : getMarginRate().hashCode());
        result = prime * result + ((getBaseCoinRate() == null) ? 0 : getBaseCoinRate().hashCode());
        result = prime * result + ((getPriceCoinRate() == null) ? 0 : getPriceCoinRate().hashCode());
        result = prime * result + ((getLockMargin() == null) ? 0 : getLockMargin().hashCode());
        result = prime * result + ((getPriceType() == null) ? 0 : getPriceType().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getOpenOrderId() == null) ? 0 : getOpenOrderId().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", marketId=").append(marketId);
        sb.append(", marketType=").append(marketType);
        sb.append(", symbol=").append(symbol);
        sb.append(", marketName=").append(marketName);
        sb.append(", price=").append(price);
        sb.append(", mergeLowPrice=").append(mergeLowPrice);
        sb.append(", mergeHighPrice=").append(mergeHighPrice);
        sb.append(", volume=").append(volume);
        sb.append(", amount=").append(amount);
        sb.append(", feeRate=").append(feeRate);
        sb.append(", fee=").append(fee);
        sb.append(", contractUnit=").append(contractUnit);
        sb.append(", deal=").append(deal);
        sb.append(", freeze=").append(freeze);
        sb.append(", marginRate=").append(marginRate);
        sb.append(", baseCoinRate=").append(baseCoinRate);
        sb.append(", priceCoinRate=").append(priceCoinRate);
        sb.append(", lockMargin=").append(lockMargin);
        sb.append(", priceType=").append(priceType);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", type=").append(type);
        sb.append(", openOrderId=").append(openOrderId);
        sb.append(", status=").append(status);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}