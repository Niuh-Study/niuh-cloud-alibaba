package com.niuh.compent.limit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hejianhui on 2020/3/3.
 */
@Configuration
public class LimitConfig {

    @Bean
    public PathKeyResovler pathKeyResovler() {
        return new PathKeyResovler();
    }
}
