package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 用户登录日志
 * @TableName user_login_log
 */
@TableName(value ="user_login_log")
@Data
public class UserLoginLog {
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
     * 客户端类型
            1-PC
            2-IOS
            3-Android
     */
    @TableField(value = "client_type")
    private Integer clientType;

    /**
     * 登录IP
     */
    @TableField(value = "login_ip")
    private String loginIp;

    /**
     * 登录地址
     */
    @TableField(value = "login_address")
    private String loginAddress;

    /**
     * 登录时间
     */
    @TableField(value = "login_time")
    private Date loginTime;

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
        UserLoginLog other = (UserLoginLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getClientType() == null ? other.getClientType() == null : this.getClientType().equals(other.getClientType()))
            && (this.getLoginIp() == null ? other.getLoginIp() == null : this.getLoginIp().equals(other.getLoginIp()))
            && (this.getLoginAddress() == null ? other.getLoginAddress() == null : this.getLoginAddress().equals(other.getLoginAddress()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getClientType() == null) ? 0 : getClientType().hashCode());
        result = prime * result + ((getLoginIp() == null) ? 0 : getLoginIp().hashCode());
        result = prime * result + ((getLoginAddress() == null) ? 0 : getLoginAddress().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
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
        sb.append(", clientType=").append(clientType);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginAddress=").append(loginAddress);
        sb.append(", loginTime=").append(loginTime);
        sb.append("]");
        return sb.toString();
    }
}