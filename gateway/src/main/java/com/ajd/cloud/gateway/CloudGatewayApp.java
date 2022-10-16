package com.ajd.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan("com.ajd.cloud.*")
public class CloudGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApp.class, args);
	}

}
