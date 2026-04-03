package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户人民币提现地址
 * @TableName user_bank
 */
@TableName(value ="user_bank")
@Data
public class UserBank {
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
     * 银行卡名称
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 开户人
     */
    @TableField(value = "real_name")
    @NotBlank
    private String realName;

    /**
     * 开户行
     */
    @TableField(value = "bank")
    @NotBlank
    private String bank;

    /**
     * 开户省
     */
    @TableField(value = "bank_prov")
    private String bankProv;

    /**
     * 开户市
     */
    @TableField(value = "bank_city")
    private String bankCity;

    /**
     * 开户地址
     */
    @TableField(value = "bank_addr")
    private String bankAddr;

    /**
     * 开户账号
     */
    @TableField(value = "bank_card")
    @NotBlank
    private String bankCard;

    /**
     * 状态：0，禁用；1，启用；
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 更新时间
     */
    @TableField(value = "last_update_time", fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;

    /**
     * 交易密码
     */
    @TableField(exist = false)
    @NotBlank
    private String payPassword;

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
        UserBank other = (UserBank) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getBankProv() == null ? other.getBankProv() == null : this.getBankProv().equals(other.getBankProv()))
            && (this.getBankCity() == null ? other.getBankCity() == null : this.getBankCity().equals(other.getBankCity()))
            && (this.getBankAddr() == null ? other.getBankAddr() == null : this.getBankAddr().equals(other.getBankAddr()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
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
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getBankProv() == null) ? 0 : getBankProv().hashCode());
        result = prime * result + ((getBankCity() == null) ? 0 : getBankCity().hashCode());
        result = prime * result + ((getBankAddr() == null) ? 0 : getBankAddr().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
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
        sb.append(", remark=").append(remark);
        sb.append(", realName=").append(realName);
        sb.append(", bank=").append(bank);
        sb.append(", bankProv=").append(bankProv);
        sb.append(", bankCity=").append(bankCity);
        sb.append(", bankAddr=").append(bankAddr);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", status=").append(status);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}