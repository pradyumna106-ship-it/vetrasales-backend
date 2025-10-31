package com.sales.savvy.dto;

public class LoginResponseDTO {
	private String role;
	private Long id;
	private String email;

	public LoginResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponseDTO(String role, Long id, String email) {
		super();
		this.role = role;
		this.id = id;
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginResponseDTO [role=" + role + ", id=" + id + ", email=" + email + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
