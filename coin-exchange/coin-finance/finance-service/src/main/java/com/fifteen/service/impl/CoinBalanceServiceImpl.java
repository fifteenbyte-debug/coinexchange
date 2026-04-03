package com.fifteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.CoinBalance;
import com.fifteen.service.CoinBalanceService;
import com.fifteen.mapper.CoinBalanceMapper;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【coin_balance(币种余额)】的数据库操作Service实现
* @createDate 2026-03-24 10:59:51
*/
@Service
public class CoinBalanceServiceImpl extends ServiceImpl<CoinBalanceMapper, CoinBalance>
    implements CoinBalanceService{

}




