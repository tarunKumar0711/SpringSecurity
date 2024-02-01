package com.securitybasics2.springsecuritybasics.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	private Integer accountNumber;
	
	private Integer customerId;
	private LocalDateTime transactionDate;
	private String transactionType;
	private Integer transactionAmount;
	private Integer closingAmount;
	private LocalDateTime createDate;
}
