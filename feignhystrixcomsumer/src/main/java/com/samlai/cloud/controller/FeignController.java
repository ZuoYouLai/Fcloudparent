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
}
