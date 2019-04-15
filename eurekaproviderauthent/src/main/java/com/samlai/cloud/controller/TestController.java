package com.samlai.cloud.controller;

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

    @GetMapping("/au/test")
    public Map getOneMap() {
        Map map = new HashMap();
        map.put("prod", "authent-prod");
        map.put("key", "authent-prodvider");
        map.put("value", "authent-oneValue");
        return map;
    }


}
