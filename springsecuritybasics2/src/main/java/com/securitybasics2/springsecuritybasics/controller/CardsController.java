package com.securitybasics2.springsecuritybasics.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitybasics2.springsecuritybasics.entity.Cards;
import com.securitybasics2.springsecuritybasics.repos.CardRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {
	
	private final CardRepository cardRepository;
	
	@GetMapping("/myCards/{customerId}")
	public ResponseEntity<?> getCardDetails(@PathVariable("cardId") Long cardId){
		Optional<Cards>  card = cardRepository.findById(cardId);
		if(Objects.nonNull(card)) {
			return new ResponseEntity<>(card.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);

		}
	}

}
