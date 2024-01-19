package com.securitybasics2.springsecuritybasics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

	@GetMapping("/contact")
	public String saveContactEnquiry() {
		return "Inquiry Details are saved into the db";
	}

}