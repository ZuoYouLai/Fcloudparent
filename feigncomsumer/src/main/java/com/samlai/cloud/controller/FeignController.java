package com.samlai.cloud.controller;

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

    @GetMapping("/test")
    public Map getRibbon() {
        Map map = this.cFeignClient.test();
        return map;
    }


    @GetMapping("/time/test")
    public String timeTest() throws InterruptedException {
        int rand = Math.round(2);
        Thread.sleep(rand * 1000);
        return "来自feign-comsumer的测试,随机时间为:" + rand + "s";
    }



}
