package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 开仓订单信息
 * @TableName forex_open_position_order
 */
@TableName(value ="forex_open_position_order")
@Data
public class ForexOpenPositionOrder {
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
     * 结算币种
     */
    @TableField(value = "coin_id")
    private Long coinId;

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
     * 委托订单
     */
    @TableField(value = "entrust_order_id")
    private Long entrustOrderId;

    /**
     * 成交订单号
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 成交价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 成交数量
     */
    @TableField(value = "num")
    private BigDecimal num;

    /**
     * 扣除保证金
     */
    @TableField(value = "lock_margin")
    private BigDecimal lockMargin;

    /**
     * 平仓量
     */
    @TableField(value = "close_num")
    private BigDecimal closeNum;

    /**
     * 状态：1：未平仓；2-已平仓
     */
    @TableField(value = "status")
    private Integer status;

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
        ForexOpenPositionOrder other = (ForexOpenPositionOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getMarketName() == null ? other.getMarketName() == null : this.getMarketName().equals(other.getMarketName()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getEntrustOrderId() == null ? other.getEntrustOrderId() == null : this.getEntrustOrderId().equals(other.getEntrustOrderId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getLockMargin() == null ? other.getLockMargin() == null : this.getLockMargin().equals(other.getLockMargin()))
            && (this.getCloseNum() == null ? other.getCloseNum() == null : this.getCloseNum().equals(other.getCloseNum()))
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
        result = prime * result + ((getMarketName() == null) ? 0 : getMarketName().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getEntrustOrderId() == null) ? 0 : getEntrustOrderId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getLockMargin() == null) ? 0 : getLockMargin().hashCode());
        result = prime * result + ((getCloseNum() == null) ? 0 : getCloseNum().hashCode());
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
        sb.append(", marketName=").append(marketName);
        sb.append(", coinId=").append(coinId);
        sb.append(", type=").append(type);
        sb.append(", accountId=").append(accountId);
        sb.append(", entrustOrderId=").append(entrustOrderId);
        sb.append(", orderId=").append(orderId);
        sb.append(", price=").append(price);
        sb.append(", num=").append(num);
        sb.append(", lockMargin=").append(lockMargin);
        sb.append(", closeNum=").append(closeNum);
        sb.append(", status=").append(status);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}