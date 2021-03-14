package com.niuh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Niuh05MsAlibabaRibbonWithSentinelExtensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Niuh05MsAlibabaRibbonWithSentinelExtensionApplication.class, args);
	}

}
