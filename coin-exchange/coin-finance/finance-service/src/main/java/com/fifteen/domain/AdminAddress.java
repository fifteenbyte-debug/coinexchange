package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 平台归账手续费等账户
 * @TableName admin_address
 */
@TableName(value ="admin_address")
@Data
public class AdminAddress {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 币种Id
     */
    @TableField(value = "coin_id")
    @NotNull
    private Long coinId;

    /**
     * eth keystore
     */
    @TableField(value = "keystore")
    private String keystore;

    /**
     * eth账号密码
     */
    @TableField(value = "pwd")
    private String pwd;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 1:归账(冷钱包地址),2:打款,3:手续费
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 类型
     */
    @TableField(value = "coin_type")
    private String coinType;

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
        AdminAddress other = (AdminAddress) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getKeystore() == null ? other.getKeystore() == null : this.getKeystore().equals(other.getKeystore()))
            && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCoinType() == null ? other.getCoinType() == null : this.getCoinType().equals(other.getCoinType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getKeystore() == null) ? 0 : getKeystore().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCoinType() == null) ? 0 : getCoinType().hashCode());
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
        sb.append(", keystore=").append(keystore);
        sb.append(", pwd=").append(pwd);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", coinType=").append(coinType);
        sb.append("]");
        return sb.toString();
    }
}