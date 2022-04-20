package com.premukkoji.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotEmpty(message="firstName field cannot be Empty")
	@NotBlank(message="firstName field cannot be Blank")
	private String firstName;
	
	@NotEmpty(message="lastName field cannot be Empty")
	@NotBlank(message="lastName field cannot be Blank")
	private String lastName;
	
	@NotEmpty(message="email field cannot be Empty")
	@NotBlank(message="email field cannot be Blank")
	@Email(message="improper email address")
	private String email;
	
	@NotEmpty(message="email field cannot be Empty")
	@NotBlank(message="email field cannot be Blank")
	@Size(min=8, max=16, message="Password length >=8 and <=16")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
