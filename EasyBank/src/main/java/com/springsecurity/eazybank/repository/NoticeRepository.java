package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.NoticeDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeDetails, Long> {
    List<NoticeDetails> findByEndDateBefore(Date date);
}
