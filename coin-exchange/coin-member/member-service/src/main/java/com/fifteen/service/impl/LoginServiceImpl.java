package com.fifteen.service.impl;

import cn.hutool.log.Log;
import com.alibaba.fastjson.JSONObject;
import com.fifteen.feign.JwtToken;
import com.fifteen.feign.OAuth2FeignClient;
import com.fifteen.model.LoginForm;
import com.fifteen.model.LoginUser;
import com.fifteen.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {


    @Value("${basic.token:Basic Y29pbi1hcGk6Y29pbi1zZWNyZXQ=}")
    private String baseToken;

    @Autowired
    private OAuth2FeignClient oAuth2FeignClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public LoginUser login(LoginForm loginForm) {
        log.info("用户{}开始登录", loginForm.getUsername());
        checkFormData(loginForm);

        //登录就是使用用户名和密码，换一个token，远程调用authorization-server
        ResponseEntity<JwtToken> token = oAuth2FeignClient.getToken("password", loginForm.getUsername(), loginForm.getPassword(), "member_type", baseToken);
        if (token.getStatusCode() == HttpStatus.OK) {
            JwtToken jwtToken = token.getBody();
            log.info("远程调用成功，结果为：", JSONObject.toJSONString(jwtToken));
            LoginUser loginUser = new LoginUser(loginForm.getUsername(), jwtToken.getExpiresIn(), jwtToken.getTokenType() + " " + jwtToken.getAccessToken(), jwtToken.getRefreshToken());
            redisTemplate.opsForValue().set(jwtToken.getAccessToken(), "", jwtToken.getExpiresIn(), java.util.concurrent.TimeUnit.SECONDS);
            return loginUser;
        }
        return null;
    }

    private void checkFormData(LoginForm loginForm) {

    }
}
