package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value="com.example")
public class SimpleConsumerMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleConsumerMovieApplication.class, args);
	}
	
}
