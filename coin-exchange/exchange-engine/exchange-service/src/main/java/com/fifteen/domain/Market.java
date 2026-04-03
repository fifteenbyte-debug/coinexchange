package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 交易对配置信息
 *
 * @TableName market
 */
@TableName(value = "market")
@Data
public class Market {
    /**
     * 市场ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型：1-数字货币；2：创新交易
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 交易区域ID
     */
    @TableField(value = "trade_area_id")
    @NotNull
    private Long tradeAreaId;

    /**
     * 卖方市场ID
     */
    @TableField(value = "sell_coin_id")
    @NotNull
    private Long sellCoinId;

    /**
     * 买方币种ID
     */
    @TableField(value = "buy_coin_id")
    @NotNull
    private Long buyCoinId;

    /**
     * 交易对标识
     */
    @TableField(value = "symbol")
    @NotNull
    private String symbol;

    /**
     * 名称
     */
    @TableField(value = "name")
    @NotBlank
    private String name;

    /**
     * 标题
     */
    @TableField(value = "title")
    @NotNull
    private String title;

    /**
     * 市场logo
     */
    @TableField(value = "img")
    @NotNull
    private String img;

    /**
     * 开盘价格
     */
    @TableField(value = "open_price")
    @NotNull
    private BigDecimal openPrice;

    /**
     * 买入手续费率
     */
    @TableField(value = "fee_buy")
    @NotNull
    private BigDecimal feeBuy;

    /**
     * 卖出手续费率
     */
    @TableField(value = "fee_sell")
    @NotNull
    private BigDecimal feeSell;

    /**
     * 保证金占用比例
     */
    @TableField(value = "margin_rate")
    private BigDecimal marginRate;

    /**
     * 单笔最小委托量
     */
    @TableField(value = "num_min")
    @NotNull
    private BigDecimal numMin;

    /**
     * 单笔最大委托量
     */
    @TableField(value = "num_max")
    @NotNull
    private BigDecimal numMax;

    /**
     * 单笔最小成交额
     */
    @TableField(value = "trade_min")
    @NotNull
    private BigDecimal tradeMin;

    /**
     * 单笔最大成交额
     */
    @TableField(value = "trade_max")
    @NotNull
    private BigDecimal tradeMax;

    /**
     * 价格小数位
     */
    @TableField(value = "price_scale")
    @NotNull
    private Integer priceScale;

    /**
     * 数量小数位
     */
    @TableField(value = "num_scale")
    @NotNull
    private Integer numScale;

    /**
     * 合约单位
     */
    @TableField(value = "contract_unit")
    private Integer contractUnit;

    /**
     * 点
     */
    @TableField(value = "point_value")
    private BigDecimal pointValue;

    /**
     * 合并深度（格式：4,3,2）4:表示为0.0001；3：表示为0.001
     */
    @TableField(value = "merge_depth")
    @NotNull
    private String mergeDepth;

    /**
     * 交易时间
     */
    @TableField(value = "trade_time")
    @NotNull
    private String tradeTime;

    /**
     * 交易周期
     */
    @TableField(value = "trade_week")
    @NotNull
    private String tradeWeek;

    /**
     * 排序列
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态
     * 0禁用
     * 1启用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 福汇API交易对
     */
    @TableField(value = "fxcm_symbol")
    private String fxcmSymbol;

    /**
     * 对应雅虎金融API交易对
     */
    @TableField(value = "yahoo_symbol")
    private String yahooSymbol;

    /**
     * 对应阿里云API交易对
     */
    @TableField(value = "aliyun_symbol")
    private String aliyunSymbol;

    /**
     * 更新时间
     */
    @TableField(value = "last_update_time",fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

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
        Market other = (Market) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getTradeAreaId() == null ? other.getTradeAreaId() == null : this.getTradeAreaId().equals(other.getTradeAreaId()))
                && (this.getSellCoinId() == null ? other.getSellCoinId() == null : this.getSellCoinId().equals(other.getSellCoinId()))
                && (this.getBuyCoinId() == null ? other.getBuyCoinId() == null : this.getBuyCoinId().equals(other.getBuyCoinId()))
                && (this.getSymbol() == null ? other.getSymbol() == null : this.getSymbol().equals(other.getSymbol()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
                && (this.getOpenPrice() == null ? other.getOpenPrice() == null : this.getOpenPrice().equals(other.getOpenPrice()))
                && (this.getFeeBuy() == null ? other.getFeeBuy() == null : this.getFeeBuy().equals(other.getFeeBuy()))
                && (this.getFeeSell() == null ? other.getFeeSell() == null : this.getFeeSell().equals(other.getFeeSell()))
                && (this.getMarginRate() == null ? other.getMarginRate() == null : this.getMarginRate().equals(other.getMarginRate()))
                && (this.getNumMin() == null ? other.getNumMin() == null : this.getNumMin().equals(other.getNumMin()))
                && (this.getNumMax() == null ? other.getNumMax() == null : this.getNumMax().equals(other.getNumMax()))
                && (this.getTradeMin() == null ? other.getTradeMin() == null : this.getTradeMin().equals(other.getTradeMin()))
                && (this.getTradeMax() == null ? other.getTradeMax() == null : this.getTradeMax().equals(other.getTradeMax()))
                && (this.getPriceScale() == null ? other.getPriceScale() == null : this.getPriceScale().equals(other.getPriceScale()))
                && (this.getNumScale() == null ? other.getNumScale() == null : this.getNumScale().equals(other.getNumScale()))
                && (this.getContractUnit() == null ? other.getContractUnit() == null : this.getContractUnit().equals(other.getContractUnit()))
                && (this.getPointValue() == null ? other.getPointValue() == null : this.getPointValue().equals(other.getPointValue()))
                && (this.getMergeDepth() == null ? other.getMergeDepth() == null : this.getMergeDepth().equals(other.getMergeDepth()))
                && (this.getTradeTime() == null ? other.getTradeTime() == null : this.getTradeTime().equals(other.getTradeTime()))
                && (this.getTradeWeek() == null ? other.getTradeWeek() == null : this.getTradeWeek().equals(other.getTradeWeek()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getFxcmSymbol() == null ? other.getFxcmSymbol() == null : this.getFxcmSymbol().equals(other.getFxcmSymbol()))
                && (this.getYahooSymbol() == null ? other.getYahooSymbol() == null : this.getYahooSymbol().equals(other.getYahooSymbol()))
                && (this.getAliyunSymbol() == null ? other.getAliyunSymbol() == null : this.getAliyunSymbol().equals(other.getAliyunSymbol()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
                && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTradeAreaId() == null) ? 0 : getTradeAreaId().hashCode());
        result = prime * result + ((getSellCoinId() == null) ? 0 : getSellCoinId().hashCode());
        result = prime * result + ((getBuyCoinId() == null) ? 0 : getBuyCoinId().hashCode());
        result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getOpenPrice() == null) ? 0 : getOpenPrice().hashCode());
        result = prime * result + ((getFeeBuy() == null) ? 0 : getFeeBuy().hashCode());
        result = prime * result + ((getFeeSell() == null) ? 0 : getFeeSell().hashCode());
        result = prime * result + ((getMarginRate() == null) ? 0 : getMarginRate().hashCode());
        result = prime * result + ((getNumMin() == null) ? 0 : getNumMin().hashCode());
        result = prime * result + ((getNumMax() == null) ? 0 : getNumMax().hashCode());
        result = prime * result + ((getTradeMin() == null) ? 0 : getTradeMin().hashCode());
        result = prime * result + ((getTradeMax() == null) ? 0 : getTradeMax().hashCode());
        result = prime * result + ((getPriceScale() == null) ? 0 : getPriceScale().hashCode());
        result = prime * result + ((getNumScale() == null) ? 0 : getNumScale().hashCode());
        result = prime * result + ((getContractUnit() == null) ? 0 : getContractUnit().hashCode());
        result = prime * result + ((getPointValue() == null) ? 0 : getPointValue().hashCode());
        result = prime * result + ((getMergeDepth() == null) ? 0 : getMergeDepth().hashCode());
        result = prime * result + ((getTradeTime() == null) ? 0 : getTradeTime().hashCode());
        result = prime * result + ((getTradeWeek() == null) ? 0 : getTradeWeek().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFxcmSymbol() == null) ? 0 : getFxcmSymbol().hashCode());
        result = prime * result + ((getYahooSymbol() == null) ? 0 : getYahooSymbol().hashCode());
        result = prime * result + ((getAliyunSymbol() == null) ? 0 : getAliyunSymbol().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", tradeAreaId=").append(tradeAreaId);
        sb.append(", sellCoinId=").append(sellCoinId);
        sb.append(", buyCoinId=").append(buyCoinId);
        sb.append(", symbol=").append(symbol);
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", img=").append(img);
        sb.append(", openPrice=").append(openPrice);
        sb.append(", feeBuy=").append(feeBuy);
        sb.append(", feeSell=").append(feeSell);
        sb.append(", marginRate=").append(marginRate);
        sb.append(", numMin=").append(numMin);
        sb.append(", numMax=").append(numMax);
        sb.append(", tradeMin=").append(tradeMin);
        sb.append(", tradeMax=").append(tradeMax);
        sb.append(", priceScale=").append(priceScale);
        sb.append(", numScale=").append(numScale);
        sb.append(", contractUnit=").append(contractUnit);
        sb.append(", pointValue=").append(pointValue);
        sb.append(", mergeDepth=").append(mergeDepth);
        sb.append(", tradeTime=").append(tradeTime);
        sb.append(", tradeWeek=").append(tradeWeek);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", fxcmSymbol=").append(fxcmSymbol);
        sb.append(", yahooSymbol=").append(yahooSymbol);
        sb.append(", aliyunSymbol=").append(aliyunSymbol);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}