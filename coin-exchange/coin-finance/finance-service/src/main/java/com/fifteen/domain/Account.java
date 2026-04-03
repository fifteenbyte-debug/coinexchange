package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 用户财产记录
 * @TableName account
 */
@TableName(value ="account")
@Data
public class Account {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 币种id
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 账号状态：1，正常；2，冻结；
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 币种可用金额
     */
    @TableField(value = "balance_amount")
    private BigDecimal balanceAmount;

    /**
     * 币种冻结金额
     */
    @TableField(value = "freeze_amount")
    private BigDecimal freezeAmount;

    /**
     * 累计充值金额
     */
    @TableField(value = "recharge_amount")
    private BigDecimal rechargeAmount;

    /**
     * 累计提现金额
     */
    @TableField(value = "withdrawals_amount")
    private BigDecimal withdrawalsAmount;

    /**
     * 净值
     */
    @TableField(value = "net_value")
    private BigDecimal netValue;

    /**
     * 占用保证金
     */
    @TableField(value = "lock_margin")
    private BigDecimal lockMargin;

    /**
     * 持仓盈亏/浮动盈亏
     */
    @TableField(value = "float_profit")
    private BigDecimal floatProfit;

    /**
     * 总盈亏
     */
    @TableField(value = "total_profit")
    private BigDecimal totalProfit;

    /**
     * 充值地址
     */
    @TableField(value = "rec_addr")
    private String recAddr;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Long version;

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
     * 卖出价格
     */
    @TableField(exist = false)
    private BigDecimal sellRate;

    /**
     * 买入价格
     */
    @TableField(exist = false)
    private BigDecimal buyRate;

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
        Account other = (Account) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBalanceAmount() == null ? other.getBalanceAmount() == null : this.getBalanceAmount().equals(other.getBalanceAmount()))
            && (this.getFreezeAmount() == null ? other.getFreezeAmount() == null : this.getFreezeAmount().equals(other.getFreezeAmount()))
            && (this.getRechargeAmount() == null ? other.getRechargeAmount() == null : this.getRechargeAmount().equals(other.getRechargeAmount()))
            && (this.getWithdrawalsAmount() == null ? other.getWithdrawalsAmount() == null : this.getWithdrawalsAmount().equals(other.getWithdrawalsAmount()))
            && (this.getNetValue() == null ? other.getNetValue() == null : this.getNetValue().equals(other.getNetValue()))
            && (this.getLockMargin() == null ? other.getLockMargin() == null : this.getLockMargin().equals(other.getLockMargin()))
            && (this.getFloatProfit() == null ? other.getFloatProfit() == null : this.getFloatProfit().equals(other.getFloatProfit()))
            && (this.getTotalProfit() == null ? other.getTotalProfit() == null : this.getTotalProfit().equals(other.getTotalProfit()))
            && (this.getRecAddr() == null ? other.getRecAddr() == null : this.getRecAddr().equals(other.getRecAddr()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBalanceAmount() == null) ? 0 : getBalanceAmount().hashCode());
        result = prime * result + ((getFreezeAmount() == null) ? 0 : getFreezeAmount().hashCode());
        result = prime * result + ((getRechargeAmount() == null) ? 0 : getRechargeAmount().hashCode());
        result = prime * result + ((getWithdrawalsAmount() == null) ? 0 : getWithdrawalsAmount().hashCode());
        result = prime * result + ((getNetValue() == null) ? 0 : getNetValue().hashCode());
        result = prime * result + ((getLockMargin() == null) ? 0 : getLockMargin().hashCode());
        result = prime * result + ((getFloatProfit() == null) ? 0 : getFloatProfit().hashCode());
        result = prime * result + ((getTotalProfit() == null) ? 0 : getTotalProfit().hashCode());
        result = prime * result + ((getRecAddr() == null) ? 0 : getRecAddr().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
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
        sb.append(", coinId=").append(coinId);
        sb.append(", status=").append(status);
        sb.append(", balanceAmount=").append(balanceAmount);
        sb.append(", freezeAmount=").append(freezeAmount);
        sb.append(", rechargeAmount=").append(rechargeAmount);
        sb.append(", withdrawalsAmount=").append(withdrawalsAmount);
        sb.append(", netValue=").append(netValue);
        sb.append(", lockMargin=").append(lockMargin);
        sb.append(", floatProfit=").append(floatProfit);
        sb.append(", totalProfit=").append(totalProfit);
        sb.append(", recAddr=").append(recAddr);
        sb.append(", version=").append(version);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}