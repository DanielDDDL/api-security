package com.daniel.example.restful_api_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class RestfulApiSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiSecurityApplication.class, args);
	}
}
