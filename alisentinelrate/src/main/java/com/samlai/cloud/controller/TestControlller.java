package com.samlai.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-25 18:12
 * @ Description：
 */
@Slf4j
@RestController
public class TestControlller {

    @GetMapping("/hello")
    public String hello() {
        return "hello samlai ~~~";
    }
}
