package com.sales.savvy.dto;

public class DeliveryOtpValidateDTO {
	private String deliveryEmail;
	private String otp;

	public String getDeliveryEmail() {
		return deliveryEmail;
	}

	public void setDeliveryEmail(String deliveryEmail) {
		this.deliveryEmail = deliveryEmail;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "DeliveryOtpValidateDTO{" + "deliveryEmail='" + deliveryEmail + '\'' + ", otp='" + otp + '\'' + '}';
	}
}
