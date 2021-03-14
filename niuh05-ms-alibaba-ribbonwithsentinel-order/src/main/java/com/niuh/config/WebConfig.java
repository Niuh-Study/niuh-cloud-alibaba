package com.niuh.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.niuh.handler.GlobalExceptionHandler;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hejianhui on 2019/11/18.
 */
@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced
    @SentinelRestTemplate(
            blockHandler = "handleException",blockHandlerClass = GlobalExceptionHandler.class,
            fallback = "fallback",fallbackClass = GlobalExceptionHandler.class

    )
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
