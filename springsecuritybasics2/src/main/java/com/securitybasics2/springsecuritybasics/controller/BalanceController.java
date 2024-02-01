package com.securitybasics2.springsecuritybasics.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitybasics2.springsecuritybasics.entity.AccountTransactions;
import com.securitybasics2.springsecuritybasics.repos.AccountTransactionRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/balances")
@RequiredArgsConstructor
public class BalanceController {
	
	private final AccountTransactionRepository accountTransactionRepository;
	
	@GetMapping("/balance/{transactionId}")
	public ResponseEntity<?> getBalanceDetails(@PathVariable("transactionId") Integer transactionId){
		 Optional<AccountTransactions> accountTransactions = accountTransactionRepository.findById(transactionId);
		 if (Objects.nonNull(accountTransactions)) {
			return new ResponseEntity<>(accountTransactions.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("No Details Found", HttpStatus.NOT_FOUND);
		 
//		 return accountTransactions.map(details -> 
//		 			new ResponseEntity<>(details, HttpStatus.OK))
//				 .orElse( new ResponseEntity<>("No Details Found", HttpStatus.NOT_FOUND));
	}
	
}
