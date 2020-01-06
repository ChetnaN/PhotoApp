package com.photoApp.app.ws.mobile.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photoApp.app.ws.mobile.app.ws.ui.model.request.UpdateUserDetailsRequest;
import com.photoApp.app.ws.mobile.app.ws.ui.model.request.UserDetailsRequest;
import com.photoApp.app.ws.mobile.app.ws.ui.model.response.User;
import com.photoApp.app.ws.mobile.app.ws.userservice.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	Map<String, User> users;
	
	@Autowired
	private UserService userService;

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "1") int limit) {
		return "get user was called on page " + page + " limit = " + limit;
	}

	@GetMapping(path = "/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			return new ResponseEntity<User>(users.get(userId), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailsRequest userDetails) {
		User userResponse = userService.createUser(userDetails);
		
		return new ResponseEntity<User>(userResponse, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequest updateUserDetails) {
		if(users.containsKey(userId)) {
			User storedUserDetails = users.get(userId);
			storedUserDetails.setFirstName(updateUserDetails.getFirstName());
			storedUserDetails.setLastName(updateUserDetails.getLastName());
			
			users.put(userId, storedUserDetails);
			return new ResponseEntity<User>(users.get(userId), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
