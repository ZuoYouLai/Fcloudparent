package com.samlai.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequestMapping("/ribbon")
@RestController
public class RibbonController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/test")
    public Map getRibbon() {
        Map map = this.restTemplate.getForObject("http://provider/test", Map.class);
        return map;
    }

}
