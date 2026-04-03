package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 监测当前服务器Ip状态
 * @TableName coin_server
 */
@TableName(value ="coin_server")
@Data
public class CoinServer {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 钱包服务器ip
     */
    @TableField(value = "rpc_ip")
    private String rpcIp;

    /**
     * 钱包服务器ip
     */
    @TableField(value = "rpc_port")
    private String rpcPort;

    /**
     * 服务是否运行 0:正常,1:停止
     */
    @TableField(value = "running")
    private Integer running;

    /**
     * 钱包服务器区块高度
     */
    @TableField(value = "wallet_number")
    private Long walletNumber;

    /**
     * 
     */
    @TableField(value = "coin_name")
    private String coinName;

    /**
     * 备注信息
     */
    @TableField(value = "mark")
    private String mark;

    /**
     * 真实区块高度
     */
    @TableField(value = "real_number")
    private Long realNumber;

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
        CoinServer other = (CoinServer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRpcIp() == null ? other.getRpcIp() == null : this.getRpcIp().equals(other.getRpcIp()))
            && (this.getRpcPort() == null ? other.getRpcPort() == null : this.getRpcPort().equals(other.getRpcPort()))
            && (this.getRunning() == null ? other.getRunning() == null : this.getRunning().equals(other.getRunning()))
            && (this.getWalletNumber() == null ? other.getWalletNumber() == null : this.getWalletNumber().equals(other.getWalletNumber()))
            && (this.getCoinName() == null ? other.getCoinName() == null : this.getCoinName().equals(other.getCoinName()))
            && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()))
            && (this.getRealNumber() == null ? other.getRealNumber() == null : this.getRealNumber().equals(other.getRealNumber()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRpcIp() == null) ? 0 : getRpcIp().hashCode());
        result = prime * result + ((getRpcPort() == null) ? 0 : getRpcPort().hashCode());
        result = prime * result + ((getRunning() == null) ? 0 : getRunning().hashCode());
        result = prime * result + ((getWalletNumber() == null) ? 0 : getWalletNumber().hashCode());
        result = prime * result + ((getCoinName() == null) ? 0 : getCoinName().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        result = prime * result + ((getRealNumber() == null) ? 0 : getRealNumber().hashCode());
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
        sb.append(", rpcIp=").append(rpcIp);
        sb.append(", rpcPort=").append(rpcPort);
        sb.append(", running=").append(running);
        sb.append(", walletNumber=").append(walletNumber);
        sb.append(", coinName=").append(coinName);
        sb.append(", mark=").append(mark);
        sb.append(", realNumber=").append(realNumber);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}