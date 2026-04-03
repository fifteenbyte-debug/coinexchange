package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 工单记录
 * @TableName work_issue
 */
@TableName(value ="work_issue")
@Data
public class WorkIssue {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id(提问用户id)
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 回复人id
     */
    @TableField(value = "answer_user_id")
    private Long answerUserId;

    /**
     * 回复人名称
     */
    @TableField(value = "answer_name")
    private String answerName;

    /**
     * 工单内容
     */
    @TableField(value = "question")
    private String question;

    /**
     * 回答内容
     */
    @TableField(value = "answer")
    private String answer;

    /**
     * 状态：1-待回答；2-已回答；
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 修改时间
     */
    @TableField(value = "last_update_time", fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;


    /**
     * 创建工单的用户名称
     */
    @TableField(exist = false)
    public String username="测试用户";

    /**
     * 创建工单的用户真实名称
     */
    @TableField(exist = false)
    public String realName="测试真实名称";

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
        WorkIssue other = (WorkIssue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAnswerUserId() == null ? other.getAnswerUserId() == null : this.getAnswerUserId().equals(other.getAnswerUserId()))
            && (this.getAnswerName() == null ? other.getAnswerName() == null : this.getAnswerName().equals(other.getAnswerName()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
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
        result = prime * result + ((getAnswerUserId() == null) ? 0 : getAnswerUserId().hashCode());
        result = prime * result + ((getAnswerName() == null) ? 0 : getAnswerName().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
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
        sb.append(", answerUserId=").append(answerUserId);
        sb.append(", answerName=").append(answerName);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append(", status=").append(status);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}