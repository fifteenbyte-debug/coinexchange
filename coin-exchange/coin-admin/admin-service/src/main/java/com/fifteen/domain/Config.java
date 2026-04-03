package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 平台配置信息
 * @TableName config
 */
@TableName(value ="config")
@Data
public class Config {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 配置规则类型
     */
    @TableField(value = "type")
    @NotBlank
    private String type;

    /**
     * 配置规则代码
     */
    @TableField(value = "code")
    @NotBlank
    private String code;

    /**
     * 配置规则名称
     */
    @TableField(value = "name")
    @NotBlank
    private String name;

    /**
     * 配置规则描述
     */
    @TableField(value = "`desc`")
    private String desc;

    /**
     * 配置值
     */
    @TableField(value = "value")
    @NotBlank
    private String value;

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
        Config other = (Config) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", value=").append(value);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}