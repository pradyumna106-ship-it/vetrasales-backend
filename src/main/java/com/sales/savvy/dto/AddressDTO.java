package com.sales.savvy.dto;

public class AddressDTO {
	
	private String email;
	private String fullName;
	private String phone;
	private String pincode;
	private String street;
	private String city;
	private String state;
	private String landmark;
	private String type;

	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDTO(String email, String fullName, String phone, String pincode, String street, String city,
			String state, String landmark, String type) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.pincode = pincode;
		this.street = street;
		this.city = city;
		this.state = state;
		this.landmark = landmark;
		this.type = type;
	}

	@Override
	public String toString() {
		return "AddressDTO [email=" + email + ", fullName=" + fullName + ", phone=" + phone + ", pincode=" + pincode
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", landmark=" + landmark + ", type="
				+ type + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}