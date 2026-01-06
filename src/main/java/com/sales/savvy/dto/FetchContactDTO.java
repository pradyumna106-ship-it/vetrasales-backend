package com.sales.savvy.dto;

public class FetchContactDTO {
	String phone;
	String email;
	public FetchContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FetchContactDTO(String phone, String email) {
		super();
		this.phone = phone;
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "FetchContactDTO [phone=" + phone + ", email=" + email + "]";
	}
	
}
