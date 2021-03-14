package com.niuh;

import com.niuh.anno.EnableRemoteCall;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRemoteCall(scannerPackages = {"com.niuh.remote"})
public class Niuh01MsAlibabaNacosClientOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Niuh01MsAlibabaNacosClientOrderApplication.class, args);
	}

}
