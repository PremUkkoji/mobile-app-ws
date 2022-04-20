package com.premukkoji.mobileappws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.premukkoji.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.premukkoji.mobileappws.ui.model.response.UserRest;
import com.premukkoji.mobileappws.userservice.UserService;

public class UserServiceImpl implements UserService {
	
	Map<String, UserRest> users;

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest user = new UserRest();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		
		if(users==null) users = new HashMap<>();
		
		users.put(userId, user);
		
		return user;
	}

}
