package com.premukkoji.mobileappws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premukkoji.mobileappws.shared.Utils;
import com.premukkoji.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.premukkoji.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.premukkoji.mobileappws.ui.model.response.UserRest;
import com.premukkoji.mobileappws.userservice.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	Map<String, UserRest> users;
	
	Utils utils;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest user = new UserRest();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		
		String userId = utils.generateUserId();
		user.setUserId(userId);
		
		if(users==null) users = new HashMap<>();
		
		users.put(userId, user);
		
		return user;
	}

	@Override
	public UserRest getUser(String userId) {
		if(users.containsKey(userId)) {
			return users.get(userId);
		}else {
			return null;
		}
	}

	@Override
	public UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails) {
		if(users.containsKey(userId)) {
			UserRest user = users.get(userId);
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			return user;
		}else {
			return null;
		}
	}

	@Override
	public void deleteUser(String userId) {
		if(users.containsKey(userId)) {
			users.remove(userId);
		}
	}

}
