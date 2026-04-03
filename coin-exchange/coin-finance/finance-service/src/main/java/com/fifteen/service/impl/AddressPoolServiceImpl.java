package com.fifteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.AddressPool;
import com.fifteen.service.AddressPoolService;
import com.fifteen.mapper.AddressPoolMapper;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【address_pool(用户的地址池)】的数据库操作Service实现
* @createDate 2026-03-24 15:05:56
*/
@Service
public class AddressPoolServiceImpl extends ServiceImpl<AddressPoolMapper, AddressPool>
    implements AddressPoolService{

}




