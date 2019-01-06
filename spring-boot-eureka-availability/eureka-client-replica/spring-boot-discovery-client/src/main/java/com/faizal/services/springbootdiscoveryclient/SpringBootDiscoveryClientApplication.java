package com.faizal.services.springbootdiscoveryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDiscoveryClientApplication.class, args);
	}

}

