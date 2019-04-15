package com.samlai.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-15 14:37
 * @ Description：
 */
@RequestMapping("/")
@RestController
/**
 * 这个注解是刷新config的配置的内容
 */
@RefreshScope
public class ClientController {

    @Value("${k-user}")
    private String userName;
    @Value("${profile}")
    private String profile;


    @GetMapping
    public Map map() {
        Map map = new HashMap();
        map.put("userName", userName);
        map.put("profile", profile);
        return map;
    }
}
