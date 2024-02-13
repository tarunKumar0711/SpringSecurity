package com.springsecurity.eazybank.service;

import com.springsecurity.eazybank.model.Customer;
import com.springsecurity.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(Customer customer) {
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customerRepository.save(customer);
    }

    public boolean checkIfUserExist(String email) {
        return customerRepository.existsByEmail(email);
    }
}
