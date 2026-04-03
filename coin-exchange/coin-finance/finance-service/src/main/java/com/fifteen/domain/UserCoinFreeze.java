package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName user_coin_freeze
 */
@TableName(value ="user_coin_freeze")
@Data
public class UserCoinFreeze {
    /**
     * 
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 
     */
    @TableField(value = "freeze")
    private Integer freeze;

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
        UserCoinFreeze other = (UserCoinFreeze) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getFreeze() == null ? other.getFreeze() == null : this.getFreeze().equals(other.getFreeze()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getFreeze() == null) ? 0 : getFreeze().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", coinId=").append(coinId);
        sb.append(", freeze=").append(freeze);
        sb.append("]");
        return sb.toString();
    }
}