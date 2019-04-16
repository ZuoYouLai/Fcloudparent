package com.samlai.cloud.controller;

import com.samlai.cloud.client.AFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 16:19
 * @ Description：
 */
@RestController
@Slf4j
public class FeignController {

    @Autowired
    private AFeignClient aFeignClient;


    @GetMapping("/fei/test")
    public String test(String name) {
        if (Objects.isNull(name)) {
            name = "smalai";
        }
        String result = aFeignClient.hello(name);
        return " Result :    " + result;
    }

}
