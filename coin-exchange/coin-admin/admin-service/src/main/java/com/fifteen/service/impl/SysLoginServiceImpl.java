package com.fifteen.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.fifteen.domain.SysMenu;
import com.fifteen.feign.JwtToken;
import com.fifteen.feign.OAuth2FeignClient;
import com.fifteen.model.LoginResult;
import com.fifteen.service.SysLoginService;
import com.fifteen.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private OAuth2FeignClient oAuth2FeignClient;

    @Autowired
    SysMenuService sysMenuService;

    @Value("${basic.token:Basic Y29pbi1hcGk6Y29pbi1zZWNyZXQ=}")
    private String baseToken;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public LoginResult login(String username, String password) {
        log.info("用户{}开始登录", username);
        //1.获取token需要远程调用authorization-server
        ResponseEntity<JwtToken> responseEntity = oAuth2FeignClient.getToken("password", username, password, "admin_type", baseToken);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new ApiException(ApiErrorCode.FAILED);
        }
        JwtToken jwtToken = responseEntity.getBody();
        log.info("获取的token:{}", JSON.toJSONString(jwtToken, true));

        String token = jwtToken.getAccessToken();
        Jwt jwt = JwtHelper.decode(token);
        String jwtJsonStr = jwt.getClaims();
        JSONObject jwtJson = JSONObject.parseObject(jwtJsonStr);
        Long userId = Long.valueOf(jwtJson.getString("user_name"));
        //2.获取菜单数据
        List<SysMenu> menus = sysMenuService.getMenusByUserId(userId);
        //3.获取权限数据,不需要查询，因为jwt里面已经包含了
        JSONArray authoritiesJsonArray = jwtJson.getJSONArray("authorities");
        List<SimpleGrantedAuthority> authorities = authoritiesJsonArray.stream().map(authority -> new SimpleGrantedAuthority(authority.toString()))
                .collect(Collectors.toList());
        redisTemplate.opsForValue().set(token, "", jwtToken.getExpiresIn(), TimeUnit.SECONDS);
        return new LoginResult(jwtToken.getTokenType() + " " + token, menus, authorities);
    }
}
