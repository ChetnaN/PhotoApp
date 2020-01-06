package com.photoApp.app.ws.mobile.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDetailsRequest {
	@NotNull(message = "First name cannot be null")
	@Size(min=2, message = "First Name must be not less than 2 characters")
	private String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min=2, message = "Last Name must be not less than 2 characters")
	private String lastName;
}
