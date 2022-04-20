package com.premukkoji.mobileappws.ui.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UpdateUserDetailsRequestModel {
	@NotEmpty(message="firstName field cannot be Empty")
	@NotBlank(message="firstName field cannot be Blank")
	private String firstName;
	
	@NotEmpty(message="lastName field cannot be Empty")
	@NotBlank(message="lastName field cannot be Blank")
	private String lastName;

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
}
