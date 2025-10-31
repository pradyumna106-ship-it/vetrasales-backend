package com.sales.savvy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginData {

	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "Password cannot be null")
	private String password;

	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginData(
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
			@NotNull(message = "Password cannot be null") String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "LoginDataDTO [email=" + email + ", password=" + password + "]";
	}

	
}