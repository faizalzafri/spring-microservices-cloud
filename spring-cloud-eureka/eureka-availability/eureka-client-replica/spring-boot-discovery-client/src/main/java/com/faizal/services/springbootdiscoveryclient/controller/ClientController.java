package com.faizal.services.springbootdiscoveryclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${spring.profiles}")
	private String zone;

	@GetMapping("/ping")
	public List<ServiceInstance> ping() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLIENT-SERVICE");
		LOGGER.info("INSTANCES: count={}", instances.size());
		instances.stream().forEach(it -> LOGGER.info("INSTANCE: id={}, port={}", it.getServiceId(), it.getPort()));
		return instances;
	}

	@GetMapping("/pingzone")
	public String pingZone() {
		return "I am in " + zone;
	}

}
