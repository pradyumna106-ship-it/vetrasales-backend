package com.sales.savvy.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {
	private UUID id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String location;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String role;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinedDate;
    private String status;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(UUID id, String username, String email, String phone, String password, String location,
			String gender, LocalDate dob, String role, LocalDate joinedDate, String status) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.location = location;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
		this.joinedDate = joinedDate;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public LocalDate getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", gender=" + gender + ", dob=" + dob + ", role=" + role + "]";
	}
	
}
