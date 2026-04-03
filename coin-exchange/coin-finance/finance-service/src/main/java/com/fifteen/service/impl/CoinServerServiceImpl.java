package com.fifteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.CoinServer;
import com.fifteen.service.CoinServerService;
import com.fifteen.mapper.CoinServerMapper;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【coin_server(监测当前服务器Ip状态)】的数据库操作Service实现
* @createDate 2026-03-24 10:59:51
*/
@Service
public class CoinServerServiceImpl extends ServiceImpl<CoinServerMapper, CoinServer>
    implements CoinServerService{

}




