package com.securitybasics2.springsecuritybasics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notices")
public class NoticesController {
	

	
	
	private static final Logger log = LoggerFactory.getLogger(NoticesController.class);

	
	@GetMapping("/notice")
	public String getNotices() {
		return "Here are the notices details from the Db";
	}
}
