package com.samlai.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 17:08
 * @ Description：
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigController {

    @Value("${gogal.title:}")
    private String title;

    @GetMapping("/test")
    public String hello() {
        log.info("title :  {}", title);
        return title;
    }
}
