package com.securitybasics2.springsecuritybasics.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.securitybasics2.springsecuritybasics.entity.Authority;
import com.securitybasics2.springsecuritybasics.entity.Customer;
import com.securitybasics2.springsecuritybasics.repos.CustomerRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class EasyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider{
	
	private final CustomerRepository customerRepository;
	
	private final PasswordEncoder passwordEncoder;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Customer customers= customerRepository.findByEmail(username);
		if(Objects.nonNull(customers)) {
			if(passwordEncoder.matches(pwd, customers.getPwd())) {
				return new UsernamePasswordAuthenticationToken(username, pwd,getGrantedAuthorities(customers.getAuthorities()));
			}
			else {
				throw new BadCredentialsException("Invalid Password");
			}
		}
		else {
			throw new BadCredentialsException("No user registered with the details.");
		}
		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
		return authorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

	}

}
