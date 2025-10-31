package com.sales.savvy.dto;

public class AdminOtpValidateDTO {
	private String email;
	private String otp;
	public AdminOtpValidateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminOtpValidateDTO(String email, String otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "AdminOtpValidateDTO [email=" + email + ", otp=" + otp + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
}
