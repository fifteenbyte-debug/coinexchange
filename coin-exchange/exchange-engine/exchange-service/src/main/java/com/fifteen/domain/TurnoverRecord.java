package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 成交数据
 * @TableName turnover_record
 */
@TableName(value ="turnover_record")
@Data
public class TurnoverRecord {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 市场ID
     */
    @TableField(value = "market_id")
    private Long marketId;

    /**
     * 成交价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 成交数量
     */
    @TableField(value = "volume")
    private BigDecimal volume;

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
        TurnoverRecord other = (TurnoverRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMarketId() == null) ? 0 : getMarketId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
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
        sb.append(", marketId=").append(marketId);
        sb.append(", price=").append(price);
        sb.append(", volume=").append(volume);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}