package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 币种配置信息
 * @TableName coin
 */
@TableName(value ="coin")
@Data
public class Coin {
    /**
     * 币种ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 币种名称
     */
    @TableField(value = "name")
    @NotBlank
    private String name;

    /**
     * 币种标题
     */
    @TableField(value = "title")
    @NotBlank
    private String title;

    /**
     * 币种logo
     */
    @TableField(value = "img")
    @NotBlank
    private String img;

    /**
     * xnb：人民币
default：比特币系列
ETH：以太坊
ethToken：以太坊代币


     */
    @TableField(value = "type")
    @NotBlank
    private String type;

    /**
     * rgb：认购币
qbb：钱包币

     */
    @TableField(value = "wallet")
    @NotBlank
    private String wallet;

    /**
     * 小数位数
     */
    @TableField(value = "round")
    @NotNull
    private Integer round;

    /**
     * 最小提现单位
     */
    @TableField(value = "base_amount")
    @NotNull
    private BigDecimal baseAmount;

    /**
     * 单笔最小提现数量
     */
    @TableField(value = "min_amount")
    @NotNull
    private BigDecimal minAmount;

    /**
     * 单笔最大提现数量
     */
    @TableField(value = "max_amount")
    @NotNull
    private BigDecimal maxAmount;

    /**
     * 当日最大提现数量
     */
    @TableField(value = "day_max_amount")
    @NotNull
    private BigDecimal dayMaxAmount;

    /**
     * status=1：启用
0：禁用
     */
    @TableField(value = "status")
    @NotNull
    private Integer status;

    /**
     * 自动转出数量
     */
    @TableField(value = "auto_out")
    @NotNull
    private Double autoOut;

    /**
     * 手续费率
     */
    @TableField(value = "rate")
    @NotNull
    private Double rate;

    /**
     * 最低收取手续费个数
     */
    @TableField(value = "min_fee_num")
    @NotNull
    private BigDecimal minFeeNum;

    /**
     * 提现开关
     */
    @TableField(value = "withdraw_flag")
    @NotNull
    private Integer withdrawFlag;

    /**
     * 充值开关
     */
    @TableField(value = "recharge_flag")
    @NotNull
    private Integer rechargeFlag;

    /**
     * 更新时间
     */
    @TableField(value = "last_update_time",fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created",fill = FieldFill.INSERT)
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
        Coin other = (Coin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getWallet() == null ? other.getWallet() == null : this.getWallet().equals(other.getWallet()))
            && (this.getRound() == null ? other.getRound() == null : this.getRound().equals(other.getRound()))
            && (this.getBaseAmount() == null ? other.getBaseAmount() == null : this.getBaseAmount().equals(other.getBaseAmount()))
            && (this.getMinAmount() == null ? other.getMinAmount() == null : this.getMinAmount().equals(other.getMinAmount()))
            && (this.getMaxAmount() == null ? other.getMaxAmount() == null : this.getMaxAmount().equals(other.getMaxAmount()))
            && (this.getDayMaxAmount() == null ? other.getDayMaxAmount() == null : this.getDayMaxAmount().equals(other.getDayMaxAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAutoOut() == null ? other.getAutoOut() == null : this.getAutoOut().equals(other.getAutoOut()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getMinFeeNum() == null ? other.getMinFeeNum() == null : this.getMinFeeNum().equals(other.getMinFeeNum()))
            && (this.getWithdrawFlag() == null ? other.getWithdrawFlag() == null : this.getWithdrawFlag().equals(other.getWithdrawFlag()))
            && (this.getRechargeFlag() == null ? other.getRechargeFlag() == null : this.getRechargeFlag().equals(other.getRechargeFlag()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getWallet() == null) ? 0 : getWallet().hashCode());
        result = prime * result + ((getRound() == null) ? 0 : getRound().hashCode());
        result = prime * result + ((getBaseAmount() == null) ? 0 : getBaseAmount().hashCode());
        result = prime * result + ((getMinAmount() == null) ? 0 : getMinAmount().hashCode());
        result = prime * result + ((getMaxAmount() == null) ? 0 : getMaxAmount().hashCode());
        result = prime * result + ((getDayMaxAmount() == null) ? 0 : getDayMaxAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAutoOut() == null) ? 0 : getAutoOut().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getMinFeeNum() == null) ? 0 : getMinFeeNum().hashCode());
        result = prime * result + ((getWithdrawFlag() == null) ? 0 : getWithdrawFlag().hashCode());
        result = prime * result + ((getRechargeFlag() == null) ? 0 : getRechargeFlag().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", img=").append(img);
        sb.append(", type=").append(type);
        sb.append(", wallet=").append(wallet);
        sb.append(", round=").append(round);
        sb.append(", baseAmount=").append(baseAmount);
        sb.append(", minAmount=").append(minAmount);
        sb.append(", maxAmount=").append(maxAmount);
        sb.append(", dayMaxAmount=").append(dayMaxAmount);
        sb.append(", status=").append(status);
        sb.append(", autoOut=").append(autoOut);
        sb.append(", rate=").append(rate);
        sb.append(", minFeeNum=").append(minFeeNum);
        sb.append(", withdrawFlag=").append(withdrawFlag);
        sb.append(", rechargeFlag=").append(rechargeFlag);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}