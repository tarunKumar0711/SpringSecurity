package com.securitybasics2.springsecuritybasics.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitybasics2.springsecuritybasics.entity.ContactMessages;
import com.securitybasics2.springsecuritybasics.repos.ContactRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactsController {
	
	private final ContactRepository contactRepository;
	
	@GetMapping("/contact/{contactId}")
	public ResponseEntity<?> saveContactEnquiry(@PathVariable("contactId") Integer contactId) {
		Optional<ContactMessages> contactMessage = contactRepository.findById(contactId);
		if (Objects.nonNull(contactId)) {
			return new ResponseEntity<>(contactMessage, HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		}
	}
//	
//	@PostMapping("/saveContact")
//	public ResponseEntity<?> saveContactDetails(@ResponseBody

}