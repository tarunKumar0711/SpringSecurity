package com.securitybasics2.springsecuritybasics.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitybasics2.springsecuritybasics.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{ 
	
	Customer findByEmail(String email);

}
