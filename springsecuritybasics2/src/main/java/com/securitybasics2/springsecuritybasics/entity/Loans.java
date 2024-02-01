package com.securitybasics2.springsecuritybasics.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanNumber;
	
//	private Integer customerId;
	private LocalDateTime startDate;
	private String loanType;
	private Integer totalLoanAmount;
	private Integer amountPaid;
	private Integer outstandingAmount;
	private LocalDateTime createDate;
	
	@ManyToOne
	private Customer customer;

}
