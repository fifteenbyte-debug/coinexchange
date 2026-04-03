package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 短信信息
 * @TableName sms
 */
@TableName(value ="sms")
@Data
public class Sms {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 短信模板ID
     */
    @TableField(value = "template_code")
    @NotBlank
    private String templateCode;

    /**
     * 国际区号
     */
    @TableField(value = "country_code")
    @NotBlank
    private String countryCode;

    /**
     * 短信接收手机号
     */
    @TableField(value = "mobile")
    @NotBlank
    private String mobile;

    /**
     * 短信内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 短信状态：0，默认值；大于0，成功发送短信数量；小于0，异常；
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 发送时间
     */
    @TableField(value = "last_update_time", fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
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
        Sms other = (Sms) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTemplateCode() == null ? other.getTemplateCode() == null : this.getTemplateCode().equals(other.getTemplateCode()))
            && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTemplateCode() == null) ? 0 : getTemplateCode().hashCode());
        result = prime * result + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", templateCode=").append(templateCode);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", mobile=").append(mobile);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}