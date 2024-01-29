package com.securitybasics2.springsecuritybasics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitybasics2.springsecuritybasics.entity.Customer;
import com.securitybasics2.springsecuritybasics.repos.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/register")
public class LoginController {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		Customer savedCustomer = null;
		
		try {
			savedCustomer = customerRepository.save(customer);
			if(savedCustomer.getId()>0) {			
			  return new ResponseEntity<>("Resource created successfully", HttpStatus.CREATED);
		} else {
		    // Handle the case where the ID is not greater than 0, maybe there was an issue with the save.
		    return new ResponseEntity<>("Failed to create resource", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
		catch (Exception e) {
			log.info("Exception is : "+ e.getMessage());
		}
	    return new ResponseEntity<>("Failed to create resource", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
