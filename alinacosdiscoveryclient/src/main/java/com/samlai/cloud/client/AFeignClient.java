package com.samlai.cloud.client;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 16:22
 * @ Description：
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ali-nacos-discovery-server")
public interface AFeignClient {

    @GetMapping("/hello")
    String hello(@RequestParam(name = "name") String name);
}
