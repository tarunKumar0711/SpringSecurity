package com.securitybasics2.springsecuritybasics.sonfig;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.SneakyThrows;
@Configuration
public class ProjectSecurityConfig {

	
	@Bean
	@SneakyThrows
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {	
		
//		http.authorizeHttpRequests(
//				(request) -> request
//				.anyRequest().denyAll());
		
//		http.authorizeHttpRequests(
//				(request) -> request
//				.anyRequest().permitAll());
				
		http.authorizeHttpRequests(
				(requests)-> requests
				.requestMatchers("/accounts/**","/balances/**","/loans/**","/cards/**").authenticated()
				.requestMatchers("/notices/**","/contacts/**").permitAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
				
		return http.build();
	}
}
