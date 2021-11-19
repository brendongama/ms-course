package com.brendon.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brendon.hroauth.entities.User;
import com.brendon.hroauth.feignClients.UserFeignClients;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserFeignClients userFeignClients;
	
	public User findByEmail(String email) {
		User user = userFeignClients
		.findByEmail(email).getBody();
		if(user == null ) {
			throw new IllegalArgumentException("Email not found");
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClients
				.findByEmail(username).getBody();
				if(user == null ) {
					throw new UsernameNotFoundException("Email not found");
				}
				return user;
	}
	
}
