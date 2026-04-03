package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 提现审核记录
 * @TableName cash_withdraw_audit_record
 */
@TableName(value ="cash_withdraw_audit_record")
@Data
public class CashWithdrawAuditRecord {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 提币订单号
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 审核备注
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
    @TableField(value = "created")
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
        CashWithdrawAuditRecord other = (CashWithdrawAuditRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
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
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
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
        sb.append(", orderId=").append(orderId);
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