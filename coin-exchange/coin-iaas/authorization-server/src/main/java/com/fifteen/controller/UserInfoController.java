package com.fifteen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfoController {

    @RequestMapping("/user/info")
    public Principal getUserInfo(Principal principal) {
        return principal;
    }
}
