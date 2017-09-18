package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="user")
@Component
public class UserConfig {
	
	String userServiceUrl;

	public String getUserServiceUrl() {
		return userServiceUrl;
	}

	public void setUserServiceUrl(String userServiceUrl) {
		this.userServiceUrl = userServiceUrl;
	}

}
