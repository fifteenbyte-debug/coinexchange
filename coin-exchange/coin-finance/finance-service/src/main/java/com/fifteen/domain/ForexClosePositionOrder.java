package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 平仓详情
 * @TableName forex_close_position_order
 */
@TableName(value ="forex_close_position_order")
@Data
public class ForexClosePositionOrder {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 交易对ID
     */
    @TableField(value = "market_id")
    private Long marketId;

    /**
     * 交易对名称
     */
    @TableField(value = "market_name")
    private String marketName;

    /**
     * 持仓方向：1-买；2-卖
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 资金账户ID
     */
    @TableField(value = "account_id")
    private Long accountId;

    /**
     * 委托订单号
     */
    @TableField(value = "entrust_order_id")
    private Long entrustOrderId;

    /**
     * 成交订单号
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 成交价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 成交数量
     */
    @TableField(value = "num")
    private BigDecimal num;

    /**
     * 关联开仓订单号
     */
    @TableField(value = "open_id")
    private Long openId;

    /**
     * 平仓盈亏
     */
    @TableField(value = "profit")
    private BigDecimal profit;

    /**
     * 返回还保证金
     */
    @TableField(value = "unlock_margin")
    private BigDecimal unlockMargin;

    /**
     * 修改时间
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
        ForexClosePositionOrder other = (ForexClosePositionOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getMarketName() == null ? other.getMarketName() == null : this.getMarketName().equals(other.getMarketName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getEntrustOrderId() == null ? other.getEntrustOrderId() == null : this.getEntrustOrderId().equals(other.getEntrustOrderId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getProfit() == null ? other.getProfit() == null : this.getProfit().equals(other.getProfit()))
            && (this.getUnlockMargin() == null ? other.getUnlockMargin() == null : this.getUnlockMargin().equals(other.getUnlockMargin()))
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
        result = prime * result + ((getMarketName() == null) ? 0 : getMarketName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getEntrustOrderId() == null) ? 0 : getEntrustOrderId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getProfit() == null) ? 0 : getProfit().hashCode());
        result = prime * result + ((getUnlockMargin() == null) ? 0 : getUnlockMargin().hashCode());
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
        sb.append(", marketName=").append(marketName);
        sb.append(", type=").append(type);
        sb.append(", accountId=").append(accountId);
        sb.append(", entrustOrderId=").append(entrustOrderId);
        sb.append(", orderId=").append(orderId);
        sb.append(", price=").append(price);
        sb.append(", num=").append(num);
        sb.append(", openId=").append(openId);
        sb.append(", profit=").append(profit);
        sb.append(", unlockMargin=").append(unlockMargin);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}