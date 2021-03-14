package com.niuh.config;

import com.niuh.compent.common.NiuhRestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hejianhui on 2019/12/26.
 */
@Configuration
public class RibbonConfig {

    /**
     * 方法实现说明:原生的RestTemplate +@LB不行 因为在
     * InitializingBean方法执行前我们的RestTemplate还没有被增强
     * 需要自己改写RestTemplate
     * @author:hejianhui
     * @return:
     * @exception:
     * @date:2020/1/22 14:28
     */
    @Bean
    public NiuhRestTemplate restTemplate(DiscoveryClient discoveryClient) {
        return new NiuhRestTemplate(discoveryClient);
    }
}
