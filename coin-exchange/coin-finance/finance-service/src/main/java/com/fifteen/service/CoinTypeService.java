package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.CoinType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【coin_type(币种类型)】的数据库操作Service
* @createDate 2026-03-24 10:59:51
*/
public interface CoinTypeService extends IService<CoinType> {

    Page<CoinType> findByPage(Page<CoinType> page, String code);

    List<CoinType> listByStatus(Byte status);
}
