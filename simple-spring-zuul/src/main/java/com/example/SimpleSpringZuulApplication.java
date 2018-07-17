package com.example;

import com.example.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SimpleSpringZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringZuulApplication.class, args);
	}

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
