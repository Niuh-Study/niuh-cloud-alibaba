package com.niuh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Niuh02MsAlibabaCustomCfgRibbonOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Niuh02MsAlibabaCustomCfgRibbonOrderApplication.class, args);
	}

}
