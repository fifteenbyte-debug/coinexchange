package com.fifteen.service;

import com.fifteen.model.LoginForm;
import com.fifteen.model.LoginUser;

public interface LoginService {

    /**
     * 会员登录
     * @param loginForm
     * @return
     */
    LoginUser login(LoginForm loginForm);
}
