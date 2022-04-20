package com.premukkoji.mobileappws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.premukkoji.mobileappws.exceptions.UserServiceException;
import com.premukkoji.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.premukkoji.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.premukkoji.mobileappws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String, UserRest> users;
	
	@GetMapping
	public String getUser(
			@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="20") int limit,
			@RequestParam(value="sort", required=false) String sort) {
		if(sort == null) {
			sort = "desc";
		}
		return "page : " + page + ", limit : " + limit + ", sort : " + sort;
	}
	
	@GetMapping(path="/{userId}", 
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
	
		//if(true) throw new UserServiceException("user service exception thrown");
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest user = new UserRest();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		
		if(users==null) users = new HashMap<>();
		
		users.put(userId, user);
		
		return new ResponseEntity<UserRest>(user, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{userId}",
			consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, 
			@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		
		if(users.containsKey(userId)) {
			UserRest user = users.get(userId);
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
		
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			users.remove(userId);
		}
		return ResponseEntity.noContent().build();
	}
}
