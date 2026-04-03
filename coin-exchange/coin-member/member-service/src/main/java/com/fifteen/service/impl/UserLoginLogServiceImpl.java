package com.fifteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.UserLoginLog;
import com.fifteen.service.UserLoginLogService;
import com.fifteen.mapper.UserLoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【user_login_log(用户登录日志)】的数据库操作Service实现
* @createDate 2026-03-17 17:38:19
*/
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog>
    implements UserLoginLogService{

}




