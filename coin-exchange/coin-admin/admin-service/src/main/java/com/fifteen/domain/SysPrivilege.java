package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 权限配置
 *
 * @TableName sys_privilege
 */
@TableName(value = "sys_privilege")
@Data
public class SysPrivilege {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属菜单Id
     */
    @TableField(value = "menu_id")
    private Long menuId;

    /**
     * 功能点名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 功能描述
     */
    @TableField(value = "description")
    private String description;

    /**
     *
     */
    @TableField(value = "url")
    private String url;

    /**
     *
     */
    @TableField(value = "method")
    private String method;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;

    /**
     * 修改人
     */
    @TableField(value = "modify_by", fill = FieldFill.UPDATE)
    private Long modifyBy;

    /**
     * 创建时间
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;

    /**
     * 修改时间
     */
    @TableField(value = "last_update_time", fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /**
     * 标记当前的角色是否有该权限
     */
    @TableField(exist = false)
    private int own;

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
        SysPrivilege other = (SysPrivilege) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
                && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
                && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
                && (this.getModifyBy() == null ? other.getModifyBy() == null : this.getModifyBy().equals(other.getModifyBy()))
                && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getModifyBy() == null) ? 0 : getModifyBy().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menuId=").append(menuId);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", createBy=").append(createBy);
        sb.append(", modifyBy=").append(modifyBy);
        sb.append(", created=").append(created);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append("]");
        return sb.toString();
    }
}