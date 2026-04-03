package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 币种配置信息
 * @TableName coin_config
 */
@TableName(value ="coin_config")
@Data
public class CoinConfig {
    /**
     * 币种ID(对应coin表ID)
     */
    @TableId(value = "id")
    @NotNull
    private Long id;

    /**
     * 币种名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * btc-比特币系列；eth-以太坊；ethToken-以太坊代币；etc-以太经典；\r\n\r\n
     */
    @TableField(value = "coin_type")
    private String coinType;

    /**
     * 钱包最低留存的币
     */
    @TableField(value = "credit_limit")
    @NotNull
    private BigDecimal creditLimit;

    /**
     * 当触发改状态的时候,开始归集
     */
    @TableField(value = "credit_max_limit")
    private BigDecimal creditMaxLimit;

    /**
     * rpc服务ip
     */
    @TableField(value = "rpc_ip")
    @NotBlank
    private String rpcIp;

    /**
     * rpc服务port
     */
    @TableField(value = "rpc_port")
    @NotBlank
    private String rpcPort;

    /**
     * rpc用户
     */
    @TableField(value = "rpc_user")
    private String rpcUser;

    /**
     * rpc密码
     */
    @TableField(value = "rpc_pwd")
    private String rpcPwd;

    /**
     * 最后一个区块
     */
    @TableField(value = "last_block")
    private String lastBlock;

    /**
     * 钱包用户名
     */
    @TableField(value = "wallet_user")
    private String walletUser;

    /**
     * 钱包密码
     */
    @TableField(value = "wallet_pass")
    private String walletPass;

    /**
     * 代币合约地址
     */
    @TableField(value = "contract_address")
    private String contractAddress;

    /**
     * context
     */
    @TableField(value = "context")
    private String context;

    /**
     * 最低确认数
     */
    @TableField(value = "min_confirm")
    private Integer minConfirm;

    /**
     * 定时任务
     */
    @TableField(value = "task")
    private String task;

    /**
     * 是否可用0不可用,1可用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 
     */
    @TableField(value = "auto_draw_limit")
    private BigDecimal autoDrawLimit;

    /**
     * 
     */
    @TableField(value = "auto_draw")
    private Integer autoDraw;

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
        CoinConfig other = (CoinConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCoinType() == null ? other.getCoinType() == null : this.getCoinType().equals(other.getCoinType()))
            && (this.getCreditLimit() == null ? other.getCreditLimit() == null : this.getCreditLimit().equals(other.getCreditLimit()))
            && (this.getCreditMaxLimit() == null ? other.getCreditMaxLimit() == null : this.getCreditMaxLimit().equals(other.getCreditMaxLimit()))
            && (this.getRpcIp() == null ? other.getRpcIp() == null : this.getRpcIp().equals(other.getRpcIp()))
            && (this.getRpcPort() == null ? other.getRpcPort() == null : this.getRpcPort().equals(other.getRpcPort()))
            && (this.getRpcUser() == null ? other.getRpcUser() == null : this.getRpcUser().equals(other.getRpcUser()))
            && (this.getRpcPwd() == null ? other.getRpcPwd() == null : this.getRpcPwd().equals(other.getRpcPwd()))
            && (this.getLastBlock() == null ? other.getLastBlock() == null : this.getLastBlock().equals(other.getLastBlock()))
            && (this.getWalletUser() == null ? other.getWalletUser() == null : this.getWalletUser().equals(other.getWalletUser()))
            && (this.getWalletPass() == null ? other.getWalletPass() == null : this.getWalletPass().equals(other.getWalletPass()))
            && (this.getContractAddress() == null ? other.getContractAddress() == null : this.getContractAddress().equals(other.getContractAddress()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
            && (this.getMinConfirm() == null ? other.getMinConfirm() == null : this.getMinConfirm().equals(other.getMinConfirm()))
            && (this.getTask() == null ? other.getTask() == null : this.getTask().equals(other.getTask()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAutoDrawLimit() == null ? other.getAutoDrawLimit() == null : this.getAutoDrawLimit().equals(other.getAutoDrawLimit()))
            && (this.getAutoDraw() == null ? other.getAutoDraw() == null : this.getAutoDraw().equals(other.getAutoDraw()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCoinType() == null) ? 0 : getCoinType().hashCode());
        result = prime * result + ((getCreditLimit() == null) ? 0 : getCreditLimit().hashCode());
        result = prime * result + ((getCreditMaxLimit() == null) ? 0 : getCreditMaxLimit().hashCode());
        result = prime * result + ((getRpcIp() == null) ? 0 : getRpcIp().hashCode());
        result = prime * result + ((getRpcPort() == null) ? 0 : getRpcPort().hashCode());
        result = prime * result + ((getRpcUser() == null) ? 0 : getRpcUser().hashCode());
        result = prime * result + ((getRpcPwd() == null) ? 0 : getRpcPwd().hashCode());
        result = prime * result + ((getLastBlock() == null) ? 0 : getLastBlock().hashCode());
        result = prime * result + ((getWalletUser() == null) ? 0 : getWalletUser().hashCode());
        result = prime * result + ((getWalletPass() == null) ? 0 : getWalletPass().hashCode());
        result = prime * result + ((getContractAddress() == null) ? 0 : getContractAddress().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getMinConfirm() == null) ? 0 : getMinConfirm().hashCode());
        result = prime * result + ((getTask() == null) ? 0 : getTask().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAutoDrawLimit() == null) ? 0 : getAutoDrawLimit().hashCode());
        result = prime * result + ((getAutoDraw() == null) ? 0 : getAutoDraw().hashCode());
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
        sb.append(", coinType=").append(coinType);
        sb.append(", creditLimit=").append(creditLimit);
        sb.append(", creditMaxLimit=").append(creditMaxLimit);
        sb.append(", rpcIp=").append(rpcIp);
        sb.append(", rpcPort=").append(rpcPort);
        sb.append(", rpcUser=").append(rpcUser);
        sb.append(", rpcPwd=").append(rpcPwd);
        sb.append(", lastBlock=").append(lastBlock);
        sb.append(", walletUser=").append(walletUser);
        sb.append(", walletPass=").append(walletPass);
        sb.append(", contractAddress=").append(contractAddress);
        sb.append(", context=").append(context);
        sb.append(", minConfirm=").append(minConfirm);
        sb.append(", task=").append(task);
        sb.append(", status=").append(status);
        sb.append(", autoDrawLimit=").append(autoDrawLimit);
        sb.append(", autoDraw=").append(autoDraw);
        sb.append("]");
        return sb.toString();
    }
}