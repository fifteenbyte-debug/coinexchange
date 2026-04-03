package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

/**
 * 实名认证信息
 * @TableName user_auth_info
 */
@TableName(value ="user_auth_info")
@Data
public class UserAuthInfo {
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
     * 图片地址
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 序号：1-身份证正面照；2-身份证反面照；3-手持身份证照片；
     */
    @TableField(value = "serialno")
    private Integer serialno;

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
     * 用户每组审核记录唯一标识
     */
    @TableField(value = "auth_code")
    private Long authCode;

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
        UserAuthInfo other = (UserAuthInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getAuthCode() == null ? other.getAuthCode() == null : this.getAuthCode().equals(other.getAuthCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getAuthCode() == null) ? 0 : getAuthCode().hashCode());
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
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", serialno=").append(serialno);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append(", authCode=").append(authCode);
        sb.append("]");
        return sb.toString();
    }
}