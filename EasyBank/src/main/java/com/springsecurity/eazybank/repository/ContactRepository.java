package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.ContactDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactDetails, Long> {
    List<ContactDetails> findAllByContactId(Long contactId);
}
