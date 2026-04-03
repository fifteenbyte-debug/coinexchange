package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 人民币充值卡号管理
 * @TableName admin_bank
 */
@TableName(value ="admin_bank")
@Data
public class AdminBank {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 开户人姓名
     */
    @TableField(value = "name")
    @NotBlank
    private String name;

    /**
     * 开户行名称
     */
    @TableField(value = "bank_name")
    @NotBlank
    private String bankName;

    /**
     * 卡号
     */
    @TableField(value = "bank_card")
    @NotBlank
    private String bankCard;

    /**
     * 充值转换换币种ID
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 币种名称
     */
    @TableField(value = "coin_name")
    private String coinName;

    /**
     * 状态：0-无效；1-有效；
     */
    @TableField(value = "status")
    private Integer status;

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
        AdminBank other = (AdminBank) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getCoinName() == null ? other.getCoinName() == null : this.getCoinName().equals(other.getCoinName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getCoinName() == null) ? 0 : getCoinName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", bankName=").append(bankName);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", coinId=").append(coinId);
        sb.append(", coinName=").append(coinName);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}