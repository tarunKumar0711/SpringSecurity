package com.securitybasics2.springsecuritybasics.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.SneakyThrows;
@Configuration
public class ProjectSecurityConfig {

	
	@Bean
	@SneakyThrows
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {	
		
//		http.authorizeHttpRequests(
//				(request) -> request
//				.anyRequest().denyAll());
		
//		http.authorizeHttpRequests(
//				(request) -> request
//				.anyRequest().permitAll());
		CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
		requestHandler.setCsrfRequestAttributeName("_csrf");
		
		http.authorizeHttpRequests(
				(requests)-> requests
				.requestMatchers("/accounts/**","/balances/**","/loans/**","/cards/**").authenticated()
				.requestMatchers("/notices/**","/contacts/**","/register/**","/v3/api-docs","/v3/api-docs/**","/swagger-ui.html","/swagger-ui/**").permitAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		
		http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()));
		http.csrf( csrf -> csrf.csrfTokenRequestHandler(requestHandler)
				.ignoringRequestMatchers("/contacts/**","/register/**","/v3/api-docs","/v3/api-docs/**","/swagger-ui.html","/swagger-ui/**")
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
		
		return http.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("*"));
		configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(List.of("Authorization","Cache-Control","Content-Type"));
		configuration.setExposedHeaders(List.of("Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
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
		return new BCryptPasswordEncoder();
	}
	
	}