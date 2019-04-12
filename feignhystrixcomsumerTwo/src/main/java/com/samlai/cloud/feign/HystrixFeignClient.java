package com.samlai.cloud.feign;

import com.google.common.collect.Maps;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-11 15:46
 * @ Description：
 */
@FeignClient(name = "provider", fallback = HystrixFeignClient.hyClient.class )
public interface HystrixFeignClient {

    @GetMapping("/hystrix/test")
    Map hystrixtest();


    @Component
    public class hyClient implements HystrixFeignClient{
        @Override
        public Map hystrixtest() {
            Map map = Maps.newHashMap();
            map.put("value", "hystrix interface method");
            return map;
        }
    }

}
