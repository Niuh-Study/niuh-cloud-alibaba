package com.niuh.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hejianhui on 2020/2/8.
 */
@Configuration
public class IRuleConfig {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
