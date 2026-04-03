package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 数字货币提现记录
 * @TableName coin_withdraw
 */
@TableName(value ="coin_withdraw")
@Data
public class CoinWithdraw {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 币种id
     */
    @TableField(value = "coin_id")
    private Long coinId;

    /**
     * 币种名称
     */
    @TableField(value = "coin_name")
    private String coinName;

    /**
     * 币种类型
     */
    @TableField(value = "coin_type")
    private String coinType;

    /**
     * 钱包地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 交易id
     */
    @TableField(value = "txid")
    private String txid;

    /**
     * 提现量
     */
    @TableField(value = "num")
    private BigDecimal num;

    /**
     * 手续费()
     */
    @TableField(value = "fee")
    private BigDecimal fee;

    /**
     * 实际提现
     */
    @TableField(value = "mum")
    private BigDecimal mum;

    /**
     * 0站内1其他2手工提币
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 链上手续费花费
     */
    @TableField(value = "chain_fee")
    private BigDecimal chainFee;

    /**
     * 区块高度
     */
    @TableField(value = "block_num")
    private Integer blockNum;

    /**
     * 后台审核人员提币备注备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 钱包提币备注备注
     */
    @TableField(value = "wallet_mark")
    private String walletMark;

    /**
     * 当前审核级数
     */
    @TableField(value = "step")
    private Integer step;

    /**
     * 状态：0-审核中；1-成功；2-拒绝；3-撤销；4-审核通过；5-打币中；
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 审核时间
     */
    @TableField(value = "audit_time")
    private Date auditTime;

    /**
     * 修改时间
     */
    @TableField(value = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created")
    private Date created;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String realName;

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
        CoinWithdraw other = (CoinWithdraw) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCoinId() == null ? other.getCoinId() == null : this.getCoinId().equals(other.getCoinId()))
            && (this.getCoinName() == null ? other.getCoinName() == null : this.getCoinName().equals(other.getCoinName()))
            && (this.getCoinType() == null ? other.getCoinType() == null : this.getCoinType().equals(other.getCoinType()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTxid() == null ? other.getTxid() == null : this.getTxid().equals(other.getTxid()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getMum() == null ? other.getMum() == null : this.getMum().equals(other.getMum()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getChainFee() == null ? other.getChainFee() == null : this.getChainFee().equals(other.getChainFee()))
            && (this.getBlockNum() == null ? other.getBlockNum() == null : this.getBlockNum().equals(other.getBlockNum()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getWalletMark() == null ? other.getWalletMark() == null : this.getWalletMark().equals(other.getWalletMark()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCoinId() == null) ? 0 : getCoinId().hashCode());
        result = prime * result + ((getCoinName() == null) ? 0 : getCoinName().hashCode());
        result = prime * result + ((getCoinType() == null) ? 0 : getCoinType().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTxid() == null) ? 0 : getTxid().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getMum() == null) ? 0 : getMum().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getChainFee() == null) ? 0 : getChainFee().hashCode());
        result = prime * result + ((getBlockNum() == null) ? 0 : getBlockNum().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getWalletMark() == null) ? 0 : getWalletMark().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
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
        sb.append(", coinId=").append(coinId);
        sb.append(", coinName=").append(coinName);
        sb.append(", coinType=").append(coinType);
        sb.append(", address=").append(address);
        sb.append(", txid=").append(txid);
        sb.append(", num=").append(num);
        sb.append(", fee=").append(fee);
        sb.append(", mum=").append(mum);
        sb.append(", type=").append(type);
        sb.append(", chainFee=").append(chainFee);
        sb.append(", blockNum=").append(blockNum);
        sb.append(", remark=").append(remark);
        sb.append(", walletMark=").append(walletMark);
        sb.append(", step=").append(step);
        sb.append(", status=").append(status);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}