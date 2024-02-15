package com.oauth.demo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oAuth")
public class SecureController {
	
	@GetMapping("/get")
	public String hello(OAuth2AuthenticationToken token) {
		System.out.println(token.getPrincipal());
		return "secure.html";
	}

}
