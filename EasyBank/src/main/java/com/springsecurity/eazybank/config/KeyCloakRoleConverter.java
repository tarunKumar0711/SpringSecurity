package com.springsecurity.eazybank.config;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;


public class KeyCloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>>{

	@SuppressWarnings("unchecked")
	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> realmAccess = (Map<String,Object>) jwt.getClaims().get("realm_access");
		
		if(!Objects.nonNull(realmAccess)) {
			return new ArrayList<>();
		}
		
		Collection<GrantedAuthority> roles = ((List<String>) realmAccess.get("roles"))
		        .stream()
		        .map(roleName -> new SimpleGrantedAuthority("ROLE_"+roleName))
		        .collect(Collectors.toList());
		
		return roles;
	}

}
