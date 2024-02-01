package com.securitybasics2.springsecuritybasics.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitybasics2.springsecuritybasics.entity.Accounts;
import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer>{
	
	Accounts findByCustomerId(Integer customerId);
}
