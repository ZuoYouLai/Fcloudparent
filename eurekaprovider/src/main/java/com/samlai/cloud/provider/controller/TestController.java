package com.samlai.cloud.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-04 17:51
 * @ Description：
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Map getOneMap() {
        Map map = new HashMap();
        map.put("prod", "prodvider001");
        map.put("key", "prodvider");
        map.put("value", "oneValue");
        return map;
    }


    @GetMapping("/hystrix/test")
    public Map getHystrixMap() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("prod", "A");
        map.put("key", "A-Key");
        map.put("value", "A-Value");
        return map;
    }

}
