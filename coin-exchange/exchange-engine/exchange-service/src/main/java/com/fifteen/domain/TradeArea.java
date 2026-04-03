package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 交易区
 * @TableName trade_area
 */
@TableName(value ="trade_area")
@Data
public class TradeArea {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 交易区名称
     */
    @TableField(value = "name")
    @NotBlank
    private String name;

    /**
     * 交易区代码
     */
    @TableField(value = "code")
    @NotBlank
    private String code;

    /**
     * 类型：1-数字货币交易；2-创新交易使用；
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 结算币种（仅创新交易需要使用）
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 结算币种名称（仅创新交易需要使用）
     */
    @TableField(value = "coin_name")
    private String coinName;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 是否作为基础结算货币,0否1是 供统计个人账户使用
     */
    @TableField(value = "base_coin")
    private Long baseCoin;

    /**
     * 修改时间
     */
    @TableField(value = "last_update_time",fill= FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created",fill= FieldFill.INSERT)
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
        TradeArea other = (TradeArea) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getCoinName() == null ? other.getCoinName() == null : this.getCoinName().equals(other.getCoinName()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBaseCoin() == null ? other.getBaseCoin() == null : this.getBaseCoin().equals(other.getBaseCoin()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getCoinName() == null) ? 0 : getCoinName().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBaseCoin() == null) ? 0 : getBaseCoin().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", coinId=").append(coinId);
        sb.append(", coinName=").append(coinName);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", baseCoin=").append(baseCoin);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}