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
@AllArgsConstructor@NoArgsConstructor
@Data
public class NoticeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noticeId;
	
	private Integer noticeSummary;
	private Integer noticeDetails;
	private Integer noticeBegDetails;
	private Integer noticeEndDetails;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
