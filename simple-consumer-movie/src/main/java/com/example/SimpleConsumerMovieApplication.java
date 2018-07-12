package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients

@EnableHystrixDashboard
@EnableCircuitBreaker
public class SimpleConsumerMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleConsumerMovieApplication.class, args);
	}
	
}
