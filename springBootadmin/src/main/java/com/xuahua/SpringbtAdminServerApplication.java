package com.xuahua;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

/**
 * @author wyong
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/1022:29
 */
@EnableTurbineStream
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
public class SpringbtAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbtAdminServerApplication.class, args);
    }
}
