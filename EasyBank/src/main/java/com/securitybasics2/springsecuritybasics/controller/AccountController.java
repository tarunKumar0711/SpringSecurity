package com.securitybasics2.springsecuritybasics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securitybasics2.springsecuritybasics.entity.Accounts;
import com.securitybasics2.springsecuritybasics.repos.AccountRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
	
	
	private final AccountRepository accountRepository;
	
	
	@GetMapping("/myAccount/{customerId}")
	public ResponseEntity<?> getAccountDetails(@PathVariable("customerId") Integer customerId) {
		
		Accounts accounts = accountRepository.findByCustomerId(customerId);
		if (accounts!=null) {
			return new ResponseEntity<>(accounts,HttpStatus.OK);
		}
		return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/myAccount")
//	public ResponseEntity<?> getAccountDetails() {
//		return new ResponseEntity<>("Account not found", HttpStatus.OK);
//	}
//	
	 
}
