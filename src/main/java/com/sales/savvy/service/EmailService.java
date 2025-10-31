package com.sales.savvy.service;

import dto.AdminSignupDTO;
import dto.DeliverySignupDTO;

import jakarta.mail.MessagingException;
public interface EmailService {
	void processSignup(AdminSignupDTO adminDto) throws MessagingException;

	void sendOtpMail(String email, String otp);

	void delapproved(Long id);

	void delrejected(Long id);

	void rejected(Long id);

	void approved(Long id);

	void delsendOtpMail(String email, String otp);

	void processDeliverySignup(DeliverySignupDTO deliveryDto) throws MessagingException;

	void sendDeliveryOtpEmail(String email, String otpStr);

	void passChangeOtp(String email, String strOtp);

}
