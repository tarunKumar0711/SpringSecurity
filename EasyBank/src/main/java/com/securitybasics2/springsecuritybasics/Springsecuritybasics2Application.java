package com.securitybasics2.springsecuritybasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.securitybasics2.springsecuritybasics.repos.UserRepository;

@SpringBootApplication
public class Springsecuritybasics2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecuritybasics2Application.class, args);
	}

}
