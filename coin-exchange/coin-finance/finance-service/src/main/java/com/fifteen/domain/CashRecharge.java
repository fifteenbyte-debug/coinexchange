package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 充值表
 * @TableName cash_recharge
 */
@TableName(value ="cash_recharge")
@Data
public class CashRecharge {
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
     * 币种名：cny，人民币；
     */
    @TableField(value = "coin_name")
    private String coinName;

    /**
     * 数量（充值金额）
     */
    @TableField(value = "num")
    private BigDecimal num;

    /**
     * 手续费
     */
    @TableField(value = "fee")
    private BigDecimal fee;

    /**
     * 手续费币种
     */
    @TableField(value = "feecoin")
    private String feecoin;

    /**
     * 成交量（到账金额）
     */
    @TableField(value = "mum")
    private BigDecimal mum;

    /**
     * 类型：alipay，支付宝；cai1pay，财易付；bank，银联；
     */
    @TableField(value = "type")
    private String type;

    /**
     * 充值订单号
     */
    @TableField(value = "tradeno")
    private String tradeno;

    /**
     * 第三方订单号
     */
    @TableField(value = "outtradeno")
    private String outtradeno;

    /**
     * 充值备注备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 审核备注
     */
    @TableField(value = "audit_remark")
    private String auditRemark;

    /**
     * 当前审核级数
     */
    @TableField(value = "step")
    private Integer step;

    /**
     * 状态：0-待审核；1-审核通过；2-拒绝；3-充值成功；
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
     * 银行卡账户名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 开户行
     */
    @TableField(value = "bank_name")
    private String bankName;

    /**
     * 银行卡号
     */
    @TableField(value = "bank_card")
    private String bankCard;

    /**
     * 最后确认到账时间。
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
        CashRecharge other = (CashRecharge) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getCoinName() == null ? other.getCoinName() == null : this.getCoinName().equals(other.getCoinName()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getFeecoin() == null ? other.getFeecoin() == null : this.getFeecoin().equals(other.getFeecoin()))
            && (this.getMum() == null ? other.getMum() == null : this.getMum().equals(other.getMum()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTradeno() == null ? other.getTradeno() == null : this.getTradeno().equals(other.getTradeno()))
            && (this.getOuttradeno() == null ? other.getOuttradeno() == null : this.getOuttradeno().equals(other.getOuttradeno()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAuditRemark() == null ? other.getAuditRemark() == null : this.getAuditRemark().equals(other.getAuditRemark()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getLastTime() == null ? other.getLastTime() == null : this.getLastTime().equals(other.getLastTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getCoinName() == null) ? 0 : getCoinName().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getFeecoin() == null) ? 0 : getFeecoin().hashCode());
        result = prime * result + ((getMum() == null) ? 0 : getMum().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTradeno() == null) ? 0 : getTradeno().hashCode());
        result = prime * result + ((getOuttradeno() == null) ? 0 : getOuttradeno().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAuditRemark() == null) ? 0 : getAuditRemark().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
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
        sb.append(", coinName=").append(coinName);
        sb.append(", num=").append(num);
        sb.append(", fee=").append(fee);
        sb.append(", feecoin=").append(feecoin);
        sb.append(", mum=").append(mum);
        sb.append(", type=").append(type);
        sb.append(", tradeno=").append(tradeno);
        sb.append(", outtradeno=").append(outtradeno);
        sb.append(", remark=").append(remark);
        sb.append(", auditRemark=").append(auditRemark);
        sb.append(", step=").append(step);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", name=").append(name);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", lastTime=").append(lastTime);
        sb.append("]");
        return sb.toString();
    }
}