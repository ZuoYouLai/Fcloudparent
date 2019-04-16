package com.samlai.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 16:05
 * @ Description：
 */
@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/rest/test")
    public String test(String name) {
        if (Objects.isNull(name)) {
            name = "smalai";
        }
        String url = "http://ali-nacos-discovery-server/hello?name=" + name;
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + "     , return :    " + result;
    }

}


