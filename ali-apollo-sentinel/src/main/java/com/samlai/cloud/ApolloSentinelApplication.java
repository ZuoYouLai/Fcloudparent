package com.samlai.cloud;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-25 18:11
 * @ Description：
 */
@EnableApolloConfig
@SpringBootApplication
public class ApolloSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApolloSentinelApplication.class, args);
    }
}