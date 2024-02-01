package com.securitybasics2.springsecuritybasics.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitybasics2.springsecuritybasics.entity.ContactMessages;
import com.securitybasics2.springsecuritybasics.entity.Loans;

@Repository
public interface ContactRepository extends JpaRepository<ContactMessages, Integer>{

}
