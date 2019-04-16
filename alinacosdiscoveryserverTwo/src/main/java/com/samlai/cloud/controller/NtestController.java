package com.samlai.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 14:57
 * @ Description：
 */
@RestController
@Slf4j
public class NtestController {


    @GetMapping("/hello")
    public String hello(String name) {
        log.info("invoked name = " + name);
        return "pro-01    hello " + name;
    }

}
