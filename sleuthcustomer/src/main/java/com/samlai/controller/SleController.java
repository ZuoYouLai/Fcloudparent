package com.samlai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-15 17:28
 * @ Description：
 */
@RestController
public class SleController {


    @GetMapping("/test")
    public String test() throws InterruptedException {
        Thread.sleep(100 * Math.round(5));
        return "sleuth test";
    }

}
