package com.sales.savvy.dto;

public class DeliverySignupDTO {
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private String documentUrl;

	// No-arg constructor
	public DeliverySignupDTO() {
	}

	// All-args constructor
	public DeliverySignupDTO(String name, String email, String phoneNumber, String address, String documentUrl) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.documentUrl = documentUrl;
	}

	// Getters & Setters
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Override
	public String toString() {
		return "DeliverySignupDTO [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", documentUrl=" + documentUrl + "]";
	}
}