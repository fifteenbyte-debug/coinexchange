package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.Coin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.dto.CoinDto;

import java.util.List;

/**
* @author msc
* @description 针对表【coin(币种配置信息)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface CoinService extends IService<Coin> {

    Page<Coin> findByPage(String name, String type, Byte status, String title, String walletType, Page<Coin> page);

    /**
     * 使用币种的状态查询所有的币种信息
     * @param status
     * @return
     */
    List<Coin> getCoinsByStatus(Byte status);

    /**
     * 根据币种名称查询币种信息
     * @param coinName
     * @return
     */
    Coin getCoinByCoinName(String coinName);

    List<CoinDto> findList(List<Long> coinIds);
}
