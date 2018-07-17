package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
//@EnableZipkinServer
@EnableZipkinStreamServer
public class SimpleZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleZipkinServerApplication.class, args);
	}
}
