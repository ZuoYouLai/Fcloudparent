package com.samlai.cloud.comsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-04 18:13
 * @ Description：
 */
@RequestMapping("/cus")
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public Map findById() {
        Map map = this.restTemplate.getForObject("http://localhost:7101/test", Map.class);
        return map;
    }
}