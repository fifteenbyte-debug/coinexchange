package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 创新交易持仓信息
 * @TableName forex_account
 */
@TableName(value ="forex_account")
@Data
public class ForexAccount {
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
     * 交易对
     */
    @TableField(value = "market_name")
    private String marketName;

    /**
     * 持仓方向：1-买；2-卖
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 持仓量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 冻结持仓量
     */
    @TableField(value = "lock_amount")
    private BigDecimal lockAmount;

    /**
     * 状态：1-有效；2-锁定；
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
        ForexAccount other = (ForexAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getMarketName() == null ? other.getMarketName() == null : this.getMarketName().equals(other.getMarketName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getLockAmount() == null ? other.getLockAmount() == null : this.getLockAmount().equals(other.getLockAmount()))
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
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getLockAmount() == null) ? 0 : getLockAmount().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", amount=").append(amount);
        sb.append(", lockAmount=").append(lockAmount);
        sb.append(", status=").append(status);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}