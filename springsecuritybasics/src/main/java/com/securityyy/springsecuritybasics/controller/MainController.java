package com.securityyy.springsecuritybasics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class MainController {
	
	
	@GetMapping("/getMapping")
	public String sayHello() {
		return "Hello from the Security.";
	}
}
