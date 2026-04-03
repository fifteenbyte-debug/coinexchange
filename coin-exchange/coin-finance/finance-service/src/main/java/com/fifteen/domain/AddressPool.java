package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户的地址池
 * @TableName address_pool
 */
@TableName(value ="address_pool")
@Data
public class AddressPool {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 币种ID
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * keystore
     */
    @TableField(value = "keystore")
    private String keystore;

    /**
     * 密码
     */
    @TableField(value = "pwd")
    private String pwd;

    /**
     * 地址类型
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
        AddressPool other = (AddressPool) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getKeystore() == null ? other.getKeystore() == null : this.getKeystore().equals(other.getKeystore()))
            && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
            && (this.getCoinType() == null ? other.getCoinType() == null : this.getCoinType().equals(other.getCoinType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getKeystore() == null) ? 0 : getKeystore().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
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
        sb.append(", address=").append(address);
        sb.append(", keystore=").append(keystore);
        sb.append(", pwd=").append(pwd);
        sb.append(", coinType=").append(coinType);
        sb.append("]");
        return sb.toString();
    }
}