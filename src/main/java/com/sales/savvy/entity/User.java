package com.sales.savvy.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.savvy.enums.Gender;
import com.sales.savvy.enums.Role;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) // ✅ Tells JPA to auto-generate IDs
    private Long id;

    private String username;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinedDate;
    private String status;
 // User.java
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public LocalDate getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", gender=" + gender + ", location=" + location + ", dob=" + dob + ", role=" + role
				+ ", joinedDate=" + joinedDate + ", status=" + status + ", products=" + products + "]";
	}
    
}
