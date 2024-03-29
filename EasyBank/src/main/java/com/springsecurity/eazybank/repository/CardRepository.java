package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Cards, Long> {

    List<Cards> findAllByCustomerId(Long customerId);
}
