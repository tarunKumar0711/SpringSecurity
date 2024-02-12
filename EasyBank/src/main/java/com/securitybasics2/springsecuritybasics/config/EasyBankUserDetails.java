package com.securitybasics2.springsecuritybasics.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitybasics2.springsecuritybasics.entity.Customer;
import com.securitybasics2.springsecuritybasics.repos.CustomerRepository;

import lombok.Setter;


@Service
public class EasyBankUserDetails implements UserDetailsService{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName, password= null;
		List<GrantedAuthority> authorities =null;
		Customer customer = customerRepository.findByEmail(username);
		if(Objects.nonNull(customer)) {
			throw new UsernameNotFoundException("User details not found for the user:"+ username);
		}
		else {
			userName =customer.getEmail();
			password = customer.getPwd();
			authorities= new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customer.getRole()));
		}
		return new User(userName, password, authorities);
	}
	
	

}
