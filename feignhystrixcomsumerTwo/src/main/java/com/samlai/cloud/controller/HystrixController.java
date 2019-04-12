package com.samlai.cloud.controller;

import com.samlai.cloud.feign.HystrixFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-11 18:08
 * @ Description：这个熔断器再config中进行实现
 */
@RequestMapping("/hystrix")
@RestController
public class HystrixController {


    @Autowired
    private HystrixFeignClient hystrixFeignClient;

    @GetMapping("/test")
    public Map hystrixTest() {
        Map map = this.hystrixFeignClient.hystrixtest();
        return map;
    }
}
