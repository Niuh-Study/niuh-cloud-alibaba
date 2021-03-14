package com.niuh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by hejianhui on 2019/11/22.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Niuh03CustomCfgFeignOrder {

    public static void main(String[] args) {
        SpringApplication.run(Niuh03CustomCfgFeignOrder.class, args);
    }
}
