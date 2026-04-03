package com.fifteen.service;

import com.fifteen.model.LoginResult;

/**
 * 登录接口
 */
public interface SysLoginService {


    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    LoginResult login(String username, String password);
}
