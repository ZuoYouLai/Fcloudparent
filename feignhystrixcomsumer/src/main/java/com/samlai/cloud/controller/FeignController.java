package com.samlai.cloud.controller;

import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.samlai.cloud.feign.CFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-11 15:43
 * @ Description：
 */
@RestController
@RequestMapping("/feign")
public class FeignController {


    @Autowired
    private CFeignClient cFeignClient;

    @HystrixCommand(fallbackMethod = "testFallback")
    @GetMapping("/test")
    public Map getRibbon() {
        Map map = this.cFeignClient.test();
        return map;
    }


    @HystrixCommand(fallbackMethod = "testFallback")
    @GetMapping("/hystrix/test")
    public Map hystrixTest() {
        Map map = this.cFeignClient.hystrixtest();
        return map;
    }




    public Map testFallback() {
        Map map = Maps.newHashMap();
        map.put("msg", "hystrix fall callback");
        return map;
    }
}
