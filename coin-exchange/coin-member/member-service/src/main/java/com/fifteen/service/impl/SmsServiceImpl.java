package com.fifteen.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.Sms;
import com.fifteen.service.SmsService;
import com.fifteen.mapper.SmsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【sms(短信信息)】的数据库操作Service实现
* @createDate 2026-03-17 17:38:19
*/
@Service
@Slf4j
public class SmsServiceImpl extends ServiceImpl<SmsMapper, Sms>
    implements SmsService{

    @Override
    public boolean sendSms(Sms sms) {
        log.info("发送短信{}", JSON.toJSONString(sms));
        return true;
    }
}




