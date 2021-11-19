package com.brendon.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendon.hroauth.entities.User;
import com.brendon.hroauth.feignClients.UserFeignClients;

@Service
public class UserService {
	
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
	
}
