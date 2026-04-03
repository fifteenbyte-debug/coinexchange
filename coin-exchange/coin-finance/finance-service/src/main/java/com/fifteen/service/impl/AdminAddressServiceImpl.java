package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.AdminAddress;
import com.fifteen.domain.Coin;
import com.fifteen.service.AdminAddressService;
import com.fifteen.mapper.AdminAddressMapper;
import com.fifteen.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【admin_address(平台归账手续费等账户)】的数据库操作Service实现
* @createDate 2026-03-24 15:05:56
*/
@Service
public class AdminAddressServiceImpl extends ServiceImpl<AdminAddressMapper, AdminAddress>
    implements AdminAddressService{

    @Autowired
    private CoinService coinService ;
    /**
     * 条件分页查询归集地址
     *
     * @param page   分页参数
     * @param coinId 币种的Id
     * @return
     */
    @Override
    public Page<AdminAddress> findByPage(Page<AdminAddress> page, Long coinId) {
        return page(page,new LambdaQueryWrapper<AdminAddress>().eq(coinId!=null ,AdminAddress::getCoinId,coinId));
    }

    /**
     * 重新save ,为了让我们的归集地址里面包含coinType
     * @param entity
     * @return
     */
    @Override
    public boolean save(AdminAddress entity) {
        Long coinId = entity.getCoinId();
        Coin coin = coinService.getById(coinId);
        if(coin==null){
            throw new IllegalArgumentException("输入的币种id错误") ;
        }
        String type = coin.getType();
        entity.setCoinType(type);
        return super.save(entity) ;
    }
}




