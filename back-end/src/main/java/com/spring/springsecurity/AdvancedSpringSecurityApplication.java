package com.spring.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class AdvancedSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedSpringSecurityApplication.class, args);
	}

}
