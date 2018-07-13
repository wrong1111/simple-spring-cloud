package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 让注册中心发现配置服务中心
 * */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class SimpleConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleConfigServerApplication.class, args);
	}
}
