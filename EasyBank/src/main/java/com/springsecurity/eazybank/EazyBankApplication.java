package com.springsecurity.eazybank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true )
@SpringBootApplication
public class EazyBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyBankApplication.class, args);
    }

}
