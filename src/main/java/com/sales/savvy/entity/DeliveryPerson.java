package com.sales.savvy.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
public class DeliveryPerson {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Column(unique = true)
	@Email(message = "Invalid email format")
	private String email;

	@Pattern(regexp = "[0-9]{10}", message = "Invalid phone number")
	private String phone;

	private String address;

	private String documentUrl;

	private String password;

	private String status;

	private String role;

	@PrePersist
	public void setRole() {
		this.role = "delivery";
	}
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "delivery_person_id")
	private DeliveryPerson deliveryPerson;

	
	public DeliveryPerson() {
		// No-arg constructor
	}

	public DeliveryPerson(Long id, String name, String email, String phone, String address, String documentUrl,
			String password, String status, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.documentUrl = documentUrl;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	@Override
	public String toString() {
		return "DeliveryPerson{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='"
				+ phone + '\'' + ", address='" + address + '\'' + ", documentUrl='" + documentUrl + '\''
				+ ", password='" + password + '\'' + ", status='" + status + '\'' + ", role='" + role + '\'' + '}';
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getByDeliveryEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
