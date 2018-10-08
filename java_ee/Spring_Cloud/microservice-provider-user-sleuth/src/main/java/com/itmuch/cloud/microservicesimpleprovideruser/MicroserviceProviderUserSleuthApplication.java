package com.itmuch.cloud.microservicesimpleprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProviderUserSleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderUserSleuthApplication.class, args);
	}
}
