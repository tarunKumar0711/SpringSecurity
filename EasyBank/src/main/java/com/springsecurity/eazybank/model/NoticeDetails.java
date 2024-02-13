package com.springsecurity.eazybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_Id")
    private Long noticeId;

    private String title;

    private String description;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "end_date")
    private Date endDate;
}
