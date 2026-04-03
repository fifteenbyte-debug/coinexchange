package com.fifteen.service;

import com.fifteen.domain.Sms;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【sms(短信信息)】的数据库操作Service
* @createDate 2026-03-17 17:38:19
*/
public interface SmsService extends IService<Sms> {

    /**
     * 发送短信
     * @param sms
     * @return
     */
    boolean sendSms(Sms sms);
}
