package com.fifteen.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.fifteen.model.WebLog;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

@Service
public class TestServiceImpl {

    @Cached(name = "com.fifteen.service.impl.TestServiceImpl:", cacheType = CacheType.BOTH,key = "#username")
    public WebLog get(String username){
        WebLog webLog = new WebLog();
        webLog.setUsername(username);
        webLog.setResult("ok");
        return webLog;
    }
}
