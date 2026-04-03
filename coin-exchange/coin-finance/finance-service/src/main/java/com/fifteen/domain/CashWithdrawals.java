package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 提现表
 *
 * @TableName cash_withdrawals
 */
@TableName(value = "cash_withdrawals")
@Data
public class CashWithdrawals {
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
     * 币种ID
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 资金账户ID
     */
    @TableField(value = "account_id")
    private Long accountId;

    /**
     * 数量（提现金额）
     */
    @TableField(value = "num")
    private BigDecimal num;

    /**
     * 手续费
     */
    @TableField(value = "fee")
    private BigDecimal fee;

    /**
     * 到账金额
     */
    @TableField(value = "mum")
    private BigDecimal mum;

    /**
     * 开户人
     */
    @TableField(value = "truename")
    private String truename;

    /**
     * 银行名称
     */
    @TableField(value = "bank")
    private String bank;

    /**
     * 银行所在省
     */
    @TableField(value = "bank_prov")
    private String bankProv;

    /**
     * 银行所在市
     */
    @TableField(value = "bank_city")
    private String bankCity;

    /**
     * 开户行
     */
    @TableField(value = "bank_addr")
    private String bankAddr;

    /**
     * 银行账号
     */
    @TableField(value = "bank_card")
    private String bankCard;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 当前审核级数
     */
    @TableField(value = "step")
    private Integer step;

    /**
     * 状态：0-待审核；1-审核通过；2-拒绝；3-提现成功；
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "created")
    private Date created;

    /**
     * 更新时间
     */
    @TableField(value = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 最后确认提现到账时间
     */
    @TableField(value = "last_time")
    private Date lastTime;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String realName;

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
        CashWithdrawals other = (CashWithdrawals) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
                && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
                && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
                && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
                && (this.getMum() == null ? other.getMum() == null : this.getMum().equals(other.getMum()))
                && (this.getTruename() == null ? other.getTruename() == null : this.getTruename().equals(other.getTruename()))
                && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
                && (this.getBankProv() == null ? other.getBankProv() == null : this.getBankProv().equals(other.getBankProv()))
                && (this.getBankCity() == null ? other.getBankCity() == null : this.getBankCity().equals(other.getBankCity()))
                && (this.getBankAddr() == null ? other.getBankAddr() == null : this.getBankAddr().equals(other.getBankAddr()))
                && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
                && (this.getLastTime() == null ? other.getLastTime() == null : this.getLastTime().equals(other.getLastTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getMum() == null) ? 0 : getMum().hashCode());
        result = prime * result + ((getTruename() == null) ? 0 : getTruename().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getBankProv() == null) ? 0 : getBankProv().hashCode());
        result = prime * result + ((getBankCity() == null) ? 0 : getBankCity().hashCode());
        result = prime * result + ((getBankAddr() == null) ? 0 : getBankAddr().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastTime() == null) ? 0 : getLastTime().hashCode());
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
        sb.append(", accountId=").append(accountId);
        sb.append(", num=").append(num);
        sb.append(", fee=").append(fee);
        sb.append(", mum=").append(mum);
        sb.append(", truename=").append(truename);
        sb.append(", bank=").append(bank);
        sb.append(", bankProv=").append(bankProv);
        sb.append(", bankCity=").append(bankCity);
        sb.append(", bankAddr=").append(bankAddr);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", remark=").append(remark);
        sb.append(", step=").append(step);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append("]");
        return sb.toString();
    }
}