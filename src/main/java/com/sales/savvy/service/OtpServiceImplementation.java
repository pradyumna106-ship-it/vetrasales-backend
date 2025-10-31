package com.sales.savvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.AdminOtpValidateDTO;
import dto.DeliveryOtpValidateDTO;
import dto.DeliverySetPasswordDTO;
import dto.SetPasswordDTO;
import entity.Admin;
import entity.DeliveryPerPassChangeOtp;
import entity.DeliveryPerson;
import entity.Otp;
import repository.AdminRepository;
import repository.DeliveryPerPassChangeOtpRepository;
import repository.DeliveryPersonRepository;
import repository.OtpRepository;

@Service
public class OtpServiceImplementation implements OtpService {
	@Autowired private AdminRepository admRepo;

	@Autowired private OtpRepository otpRepo;
	
	@Autowired private EmailService eservice;
	
	@Autowired private DeliveryPerPassChangeOtpRepository delpassRepo;
	
	@Autowired private DeliveryPersonRepository delPerRepo;
	
	@Override
	public String generatedOtp(String email) {
		
	    Admin admin = admRepo.getByCompanyEmail(email);

	    if (admin == null) {
	        throw new RuntimeException("Admin not found for email: " + email);
	    }

	    // Generate OTP
	    SecureRandom random = new SecureRandom();
	    int num = 100000 + random.nextInt(900000);
	    String otp = String.valueOf(num);

	    // Save OTP
	    Otp ot = new Otp();
	    ot.setEmail(admin.getCompanyEmail());
	    ot.setOtp(otp);
	    otpRepo.save(ot);
	    
	    eservice.sendOtpMail(admin.getCompanyEmail(), otp);
	    return otp;
	}

	@Override
	public boolean verifyOtp(AdminOtpValidateDTO otpdto) {
		Otp otp = otpRepo.findByEmail(otpdto.getEmail());
		SetPasswordDTO setpass = new SetPasswordDTO();
		if (otp != null && otp.getOtp().equals(otpdto.getOtp())) {
			 otpRepo.delete(otp); //deleting otp after verification
			return true;
		} else {
			throw new RuntimeException("Invalid OTP");
		}
	}

	public void resetPasswordForEmail(SetPasswordDTO setpass) {
		Admin admin = admRepo.getByCompanyEmail(setpass.getEmail());

		if (admin == null) {
			throw new RuntimeException("Admin not found with email: " + setpass.getEmail());
		}

		String newpas = setpass.getNewPassword();
		admin.setPassword(newpas);
		admRepo.save(admin);
	}

	public String sendDeliveryPerChangePassword(String email) {
		Random random =  new Random();
		int otp = random.nextInt(900000) + 100000;
		String strOtp = String.valueOf(otp);
		

		DeliveryPerPassChangeOtp delPerpass = new DeliveryPerPassChangeOtp();
		delPerpass.setEmail(email);
		delPerpass.setOtp(strOtp);
		delpassRepo.save(delPerpass);
		
		eservice.passChangeOtp(email, strOtp);
		
		return strOtp;
		
	}

	@Override
	public boolean deliveryperOtpVerification(DeliveryOtpValidateDTO otpvalid) {
	    DeliveryPerPassChangeOtp otp = delpassRepo.findByEmail(otpvalid.getDeliveryEmail());
	    if (otp != null && otp.getOtp().equals(otpvalid.getOtp())) {
	        delpassRepo.delete(otp); 
	        return true;           
	    } else {
	        return false;          
	    }
	}

	@Override
	public void deliveryPerResetPassword(DeliverySetPasswordDTO setpass) {
		Optional<DeliveryPerson> delPerOtp = delPerRepo.findByEmail(setpass.getDeliveryEmail());
		
		DeliveryPerson delPer = delPerOtp.get();
		String newPass = setpass.getNewPassword();
		delPer.setPassword(newPass);
		delPerRepo.save(delPer);
	}
}
