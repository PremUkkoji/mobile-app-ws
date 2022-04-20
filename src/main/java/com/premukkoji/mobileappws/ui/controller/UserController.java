package com.premukkoji.mobileappws.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.premukkoji.mobileappws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
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
			produces= {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE}
	)
	public UserRest getUser(@PathVariable String userId) {
		UserRest user = new UserRest();
		user.setFirstName("Prem");
		user.setLastName("Ukkoji");
		user.setEmail("premukkoji@gmail.com");
		user.setUserId(userId);
		
		return user;
	}
	
	@PostMapping
	public String createUser() {
		return "create user";
	}
	
	@PutMapping
	public String updateUser() {
		return "update user";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user";
	}
}
