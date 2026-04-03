package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.CoinType;
import com.fifteen.service.CoinTypeService;
import com.fifteen.mapper.CoinTypeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author msc
 * @description 针对表【coin_type(币种类型)】的数据库操作Service实现
 * @createDate 2026-03-24 10:59:51
 */
@Service
public class CoinTypeServiceImpl extends ServiceImpl<CoinTypeMapper, CoinType>
        implements CoinTypeService {


    /**
     * 条件分页查询货币类型
     *
     * @param page 分页参数
     * @param code 类型的Code
     * @return 分页货币类型
     */
    @Override
    public Page<CoinType> findByPage(Page<CoinType> page, String code) {
        return page(page, new LambdaQueryWrapper<CoinType>()
                .like(!StringUtils.isEmpty(code), CoinType::getCode, code));
    }

    /**
     * 使用币种类型的状态查询所有的币种类型值
     *
     * @param status
     * @return
     */
    @Override
    public List<CoinType> listByStatus(Byte status) {
        return list(new LambdaQueryWrapper<CoinType>().eq(status!=null ,CoinType::getStatus,status));
    }

}




