package com.securitybasics2.springsecuritybasics.sonfig;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
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
				
		http.csrf(csrf-> csrf.disable()).authorizeHttpRequests(
				(requests)-> requests
				.requestMatchers("/accounts/**","/balances/**","/loans/**","/cards/**").authenticated()
				.requestMatchers("/notices/**","/contacts/**","/register/**").permitAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
				
		return http.build();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		
//		//By using defaultPasswordEncoder
////		UserDetails admin = User.withDefaultPasswordEncoder()
////				.username("admin")
////				.password("1234")
////				.authorities("admin") 
////				.build();
////		
////		UserDetails user = User.withDefaultPasswordEncoder()
////				.username("user")
////				.password("12345")
////				.authorities("read")
////				.build();
//		
//		
//		
//		//By using NoOpPasswordEncoder()
//		
//		UserDetails admin = User.withUsername("admin")
//				.password("1234")
//				.authorities("admin")
//				.build();
//		
//		UserDetails user = User.withUsername("user")
//				.password("12345")
//				.authorities("read")
//				.build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
//	}
	
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource datasource) {
//		return new JdbcUserDetailsManager(datasource);
//		
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	}