package com.fifteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.ForexAccount;
import com.fifteen.service.ForexAccountService;
import com.fifteen.mapper.ForexAccountMapper;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【forex_account(创新交易持仓信息)】的数据库操作Service实现
* @createDate 2026-03-24 10:59:51
*/
@Service
public class ForexAccountServiceImpl extends ServiceImpl<ForexAccountMapper, ForexAccount>
    implements ForexAccountService{

}




