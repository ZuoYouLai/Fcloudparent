package com.samlai.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-12 11:29
 * @ Description：
 */
@RequestMapping("/")
@Controller
public class IndexController {

    @GetMapping("")
    public String index() {
        return "forward:/hystrix";
    }

}
