package com.securitybasics2.springsecuritybasics.entity;
import java.time.LocalDateTime;

import org.springframework.cglib.core.TinyBitSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cards {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardId;
	private Integer cardNumber;
	
	@ManyToOne
	private Customer customer;
	private Integer cardType;
	private Integer totalLimit;
	private Integer amountUsed;
	private Integer availableAmount;
	private LocalDateTime createDate;
	

}
