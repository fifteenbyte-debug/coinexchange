package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 币种余额
 * @TableName coin_balance
 */
@TableName(value ="coin_balance")
@Data
public class CoinBalance {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 币种ID
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 币种名称
     */
    @TableField(value = "coin_name")
    private String coinName;

    /**
     * 系统余额（根据充值提币计算）
     */
    @TableField(value = "system_balance")
    private BigDecimal systemBalance;

    /**
     * 币种类型
     */
    @TableField(value = "coin_type")
    private String coinType;

    /**
     * 归集账户余额
     */
    @TableField(value = "collect_account_balance")
    private BigDecimal collectAccountBalance;

    /**
     * 钱包账户余额
     */
    @TableField(value = "loan_account_balance")
    private BigDecimal loanAccountBalance;

    /**
     * 手续费账户余额(eth转账需要手续费)
     */
    @TableField(value = "fee_account_balance")
    private BigDecimal feeAccountBalance;

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

    /**
     * 
     */
    @TableField(value = "recharge_account_balance")
    private BigDecimal rechargeAccountBalance;

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
        CoinBalance other = (CoinBalance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getCoinName() == null ? other.getCoinName() == null : this.getCoinName().equals(other.getCoinName()))
            && (this.getSystemBalance() == null ? other.getSystemBalance() == null : this.getSystemBalance().equals(other.getSystemBalance()))
            && (this.getCoinType() == null ? other.getCoinType() == null : this.getCoinType().equals(other.getCoinType()))
            && (this.getCollectAccountBalance() == null ? other.getCollectAccountBalance() == null : this.getCollectAccountBalance().equals(other.getCollectAccountBalance()))
            && (this.getLoanAccountBalance() == null ? other.getLoanAccountBalance() == null : this.getLoanAccountBalance().equals(other.getLoanAccountBalance()))
            && (this.getFeeAccountBalance() == null ? other.getFeeAccountBalance() == null : this.getFeeAccountBalance().equals(other.getFeeAccountBalance()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getRechargeAccountBalance() == null ? other.getRechargeAccountBalance() == null : this.getRechargeAccountBalance().equals(other.getRechargeAccountBalance()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getCoinName() == null) ? 0 : getCoinName().hashCode());
        result = prime * result + ((getSystemBalance() == null) ? 0 : getSystemBalance().hashCode());
        result = prime * result + ((getCoinType() == null) ? 0 : getCoinType().hashCode());
        result = prime * result + ((getCollectAccountBalance() == null) ? 0 : getCollectAccountBalance().hashCode());
        result = prime * result + ((getLoanAccountBalance() == null) ? 0 : getLoanAccountBalance().hashCode());
        result = prime * result + ((getFeeAccountBalance() == null) ? 0 : getFeeAccountBalance().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getRechargeAccountBalance() == null) ? 0 : getRechargeAccountBalance().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", coinId=").append(coinId);
        sb.append(", coinName=").append(coinName);
        sb.append(", systemBalance=").append(systemBalance);
        sb.append(", coinType=").append(coinType);
        sb.append(", collectAccountBalance=").append(collectAccountBalance);
        sb.append(", loanAccountBalance=").append(loanAccountBalance);
        sb.append(", feeAccountBalance=").append(feeAccountBalance);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append(", rechargeAccountBalance=").append(rechargeAccountBalance);
        sb.append("]");
        return sb.toString();
    }
}