package com.photoApp.app.ws.mobile.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.photoApp.app.ws.mobile.app.ws.ui.model.request.UserDetailsRequest;
import com.photoApp.app.ws.mobile.app.ws.ui.model.response.User;
import com.photoApp.app.ws.mobile.app.ws.userservice.UserService;
import com.photoApp.app.ws.mobile.app.ws.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	Map<String, User> users;
	
	Utils utils;
	
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	
	@Override
	public User createUser(UserDetailsRequest userDetails) {
		User userResponse = new User();
		userResponse.setEmail(userDetails.getEmail());
		userResponse.setFirstName(userDetails.getFirstName());
		userResponse.setLastName(userDetails.getLastName());
		
		String userId = utils.generateUserId();
		if(users == null) users = new HashMap<String, User>();
		userResponse.setUserId(userId);
		users.put(userId, userResponse);
		return userResponse;
	}

}
