package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.Accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

    Accounts findByCustomerId(Long id);
}
