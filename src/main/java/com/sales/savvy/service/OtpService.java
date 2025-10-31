package com.sales.savvy.service;

import dto.AdminOtpValidateDTO;
import dto.DeliveryOtpValidateDTO;
import dto.DeliverySetPasswordDTO;
import dto.SetPasswordDTO;

public interface OtpService {
	String generatedOtp(String email);

	boolean verifyOtp(AdminOtpValidateDTO otpdto);

	void resetPasswordForEmail(SetPasswordDTO setpass);
	
	String sendDeliveryPerChangePassword(String email);
	
	boolean deliveryperOtpVerification(DeliveryOtpValidateDTO otpvalid);

	void deliveryPerResetPassword(DeliverySetPasswordDTO setpass);
}
