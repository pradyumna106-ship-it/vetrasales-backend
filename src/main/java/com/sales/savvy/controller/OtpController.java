package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.AdminOtpValidateDTO;
import com.sales.savvy.dto.DeliveryOtpValidateDTO;
import com.sales.savvy.dto.DeliverySetPasswordDTO;
import com.sales.savvy.dto.EmailRequestDTO;
import com.sales.savvy.dto.SetPasswordDTO;
import com.sales.savvy.service.OtpService;

@CrossOrigin("*")
@RestController
public class OtpController {
	
	@Autowired private OtpService service;
	
	@PostMapping("/generatedOtp")
	public String generatedOtp(@RequestBody EmailRequestDTO emailRequest) {
		System.out.println(emailRequest);
		return service.generatedOtp(emailRequest.getEmail());
	}
	
	@PostMapping("/verifyOtp")
	public void verifyOtp(@RequestBody AdminOtpValidateDTO otpdto) {
		service.verifyOtp(otpdto);
	}
	
	@PostMapping("/setPassword")
	public void resetPasswordForEmail(@RequestBody SetPasswordDTO setpass) {
		service.resetPasswordForEmail(setpass);
	}
	
	@PostMapping("/deliveryPerOtpVerification")
	public boolean deliveryperOtpVerification(@RequestBody DeliveryOtpValidateDTO otpvalid) {
		return service.deliveryperOtpVerification(otpvalid);
	}
	
	@PostMapping("/deliveryPerResetPassword")
	public void deliveryPerResetPassword(@RequestBody DeliverySetPasswordDTO setpass) {
		service.deliveryPerResetPassword(setpass);
	}
}