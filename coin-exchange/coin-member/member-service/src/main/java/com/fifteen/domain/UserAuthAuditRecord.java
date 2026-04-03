package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

/**
 * 实名认证审核信息
 * @TableName user_auth_audit_record
 */
@TableName(value ="user_auth_audit_record")
@Data
public class UserAuthAuditRecord {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 对应user_auth_info表code
     */
    @TableField(value = "auth_code")
    private Long authCode;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 状态1同意2拒絕
     */
    @TableField(value = "status")
    private Integer status;

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
     * 审核人ID
     */
    @TableField(value = "audit_user_id")
    private Long auditUserId;

    /**
     * 审核人
     */
    @TableField(value = "audit_user_name")
    private String auditUserName;

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
        UserAuthAuditRecord other = (UserAuthAuditRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuthCode() == null ? other.getAuthCode() == null : this.getAuthCode().equals(other.getAuthCode()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getAuditUserId() == null ? other.getAuditUserId() == null : this.getAuditUserId().equals(other.getAuditUserId()))
            && (this.getAuditUserName() == null ? other.getAuditUserName() == null : this.getAuditUserName().equals(other.getAuditUserName()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuthCode() == null) ? 0 : getAuthCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getAuditUserId() == null) ? 0 : getAuditUserId().hashCode());
        result = prime * result + ((getAuditUserName() == null) ? 0 : getAuditUserName().hashCode());
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
        sb.append(", authCode=").append(authCode);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", step=").append(step);
        sb.append(", auditUserId=").append(auditUserId);
        sb.append(", auditUserName=").append(auditUserName);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}