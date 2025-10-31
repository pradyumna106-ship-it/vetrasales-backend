package com.sales.savvy.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import dto.AdminSignupDTO;
import dto.DeliverySignupDTO;
import entity.Admin;
import entity.DeliveryPerson;
import repository.AdminRepository;
import repository.DeliveryPersonRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation implements EmailService {
	@Autowired private JavaMailSender mailSender;

	@Autowired private AdminRepository repo;
	
	@Autowired private DeliveryPersonRepository deliveryRepo;
	
	public void processSignup(AdminSignupDTO adminDto) throws MessagingException {
		// setting status as pending and saving in db
		Admin admin = new Admin();
		admin.setBusinessName(adminDto.getBusinessName());
		admin.setBusinessType(adminDto.getBusinessType());
		admin.setGstNumber(adminDto.getGstNumber());
		admin.setPanNumber(adminDto.getPanNumber());
		admin.setCompanyEmail(adminDto.getCompanyEmail());
		admin.setBusinessAddress(adminDto.getBusinessAddress());
		admin.setCity(adminDto.getCity());
		admin.setState(adminDto.getState());
		admin.setPincode(adminDto.getPincode());
		admin.setDocumentPath(admin.getDocumentPath());
		
		admin.setStatus("PENDING");
		Admin savedAdmin = repo.save(admin); // We are saving the object in the database and storing it in the 'savedAdmin' object, so we can use 'savedAdmin' to get the ID in the anchor tag.
		MimeMessage message = mailSender.createMimeMessage(); // it is used to send rich content (like HTML, styled
																// buttons, attachments) in your email.

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true); // passing true to enable to want to send
																				// HTML
			helper.setTo("otpspring@gmail.com"); // reciver mail info
			helper.setSubject("New Admin Signup Request"); // subject of the mail

			String body = "<h2>New Admin Signup Request</h2>" + "<p><strong>Business Name:</strong> "
					+ admin.getBusinessName() + "<br>" + "<strong>Business Type:</strong> " + admin.getBusinessType()
					+ "<br>" + "<strong>GST Number:</strong> " + admin.getGstNumber() + "<br>"
					+ "<strong>PAN Number:</strong> " + admin.getPanNumber() + "<br>"
					+ "<strong>Company Email:</strong> " + admin.getCompanyEmail() + "<br>"
					+ "<strong>Address:</strong> " + admin.getBusinessAddress() + "<br>" + "<strong>City:</strong> "
					+ admin.getCity() + "<br>" + "<strong>State:</strong> " + admin.getState() + "<br>"
					+ "<strong>Pincode:</strong> " + admin.getPincode() + "<br>" + "<strong>Document Path:</strong> "
					+ admin.getDocumentPath() + "</p><br>" +

					"<a href='http://localhost:8080/approved?id=" + savedAdmin.getId() + "' "
					+ "style='padding:10px;background-color:green;color:white;'>Approve</a> "
					+ "<a href='http://localhost:8080/rejected?id= " + savedAdmin.getId() + "' "
					+ " style='padding:10px;background-color:red;color:white;'>Reject</a>";

			helper.setText(body, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void approved(Long id) {
		// getting admin ibj by using id
		Admin admin = repo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));

		// setting random password
		SecureRandom random = new SecureRandom();
		int num = 100000 + random.nextInt(900000);
		String password = String.valueOf(num);

		admin.setPassword(password); // setting password to admin
		admin.setStatus("APPROVED"); // setting status
		repo.save(admin); // saving admin in database

		// Approval message
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(admin.getCompanyEmail());
		message.setSubject("Application Status - Approved by OftenShopping");
		String Body = "Dear " + admin.getBusinessName() + ",\n\n" + "Your admin account has been approved.\n"
				+ "Your temporary password is: " + password + "\n\n"
				+ "Please log in and change your password after logging in.\n\n" + "Regards,\nOftenShopping Team";

		message.setText(Body);
		mailSender.send(message);
	}

	@Override
	public void rejected(Long id) {

		// getting admin ibj by using id
		Admin admin = repo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));

		admin.setStatus("REJECTED");
		repo.save(admin);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(admin.getCompanyEmail());
		message.setSubject("Application Status - Rejected by OftenShopping");

		String body = "Dear " + admin.getBusinessName() + ",\n\n"
				+ "Thank you for showing interest in joining the OftenShopping platform.\n"
				+ "We have carefully reviewed the details you provided. Unfortunately, your application does not meet our current requirements.\n\n"
				+ "We truly appreciate your time and effort, and we encourage you to apply again in the future should your business profile change.\n\n"
				+ "If you believe this decision was made in error or wish to know more, feel free to reach out to us at support@oftenshopping.com.\n\n"
				+ "Best regards,\n" + "The OftenShopping Team";

		message.setText(body);
		mailSender.send(message);

	}

	public void sendOtpMail(String email, String otp) {
	    try {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Otp to change password");
	        message.setText("Otp to generate new Password: " + otp);
	        mailSender.send(message);
	        System.out.println("Email sent to: " + email);
	    } catch (Exception e) {
	        e.printStackTrace(); // Log error
	        System.out.println("Failed to send email: " + e.getMessage());
	    }
	}
		
		public void processDeliverySignup(DeliverySignupDTO deliveryDto) throws MessagingException {
		    DeliveryPerson dp = new DeliveryPerson();
		    dp.setName(deliveryDto.getName());
		    dp.setEmail(deliveryDto.getEmail());
		    dp.setPhone(deliveryDto.getPhoneNumber()); 
		    dp.setAddress(deliveryDto.getAddress());
		    dp.setDocumentUrl(deliveryDto.getDocumentUrl());
		    dp.setStatus("PENDING");
	
		    DeliveryPerson savedDP = deliveryRepo.save(dp);
	
		    MimeMessage message = mailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	
		    helper.setTo("otpspring@gmail.com");
		    helper.setSubject("New Delivery Person Signup Request");
	
		    String body = "<h2>New Delivery Person Signup</h2>"
		        + "<p><strong>Name:</strong> " + dp.getName() + "<br>"
		        + "<strong>Email:</strong> " + dp.getEmail() + "<br>"
		        + "<strong>Phone:</strong> " + dp.getPhone() + "<br>"
		        + "<strong>Address:</strong> " + dp.getAddress() + "<br>"
		        + "<strong>Document URL:</strong> " + dp.getDocumentUrl() + "</p><br>"
		        + "<a href='http://localhost:8080/deliveryApproved?id=" + savedDP.getId() + "' "
		        + "style='padding:10px;background-color:green;color:white;text-decoration:none;'>Approve</a> "
		        + "<a href='http://localhost:8080/deliveryRejected?id=" + savedDP.getId() + "' "
		        + "style='padding:10px;background-color:red;color:white;text-decoration:none;'>Reject</a>";
	
		    helper.setText(body, true);
		    mailSender.send(message);
		}
		
		@Override
		public void delapproved(Long id) {
		    DeliveryPerson deliveryPerson = deliveryRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("Delivery person not found with ID: " + id));
	
		    // Generate random temporary password
		    SecureRandom random = new SecureRandom();
		    int num = 100000 + random.nextInt(900000);
		    String password = String.valueOf(num);
	
		    deliveryPerson.setPassword(password);
		    deliveryPerson.setStatus("APPROVED");
		    deliveryRepo.save(deliveryPerson);
	
		    // Send approval mail
		    SimpleMailMessage message = new SimpleMailMessage();
		    message.setTo(deliveryPerson.getEmail());
		    message.setSubject("Delivery Person Application Approved - OftenShopping");
	
		    String body = "Dear " + deliveryPerson.getName() + ",\n\n"
		            + "Your application to become a delivery partner has been approved.\n"
		            + "Your temporary password is: " + password + "\n\n"
		            + "Please log in and change your password after logging in.\n\n"
		            + "Regards,\nThe OftenShopping Team";
	
		    message.setText(body);
		    mailSender.send(message);
		}
	
	
		@Override
		public void delrejected(Long id) {
		    DeliveryPerson deliveryPerson = deliveryRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("Delivery person not found with ID: " + id));
	
		    deliveryPerson.setStatus("REJECTED");
		    deliveryRepo.save(deliveryPerson);
	
		    SimpleMailMessage message = new SimpleMailMessage();
		    message.setTo(deliveryPerson.getEmail());
		    message.setSubject("Delivery Person Application Rejected - OftenShopping");
	
		    String body = "Dear " + deliveryPerson.getName() + ",\n\n"
		            + "Thank you for applying to be a delivery partner with OftenShopping.\n"
		            + "After reviewing your application, we regret to inform you that it does not meet our current requirements.\n\n"
		            + "You are welcome to apply again in the future if your circumstances change.\n\n"
		            + "For questions, reach out to support@oftenshopping.com.\n\n"
		            + "Best regards,\nThe OftenShopping Team";
	
		    message.setText(body);
		    mailSender.send(message);
		}
		
		public void delsendOtpMail(String email, String otp) {
		    try {
		        SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(email);
		        message.setSubject("OTP to Change Password");
		        message.setText("Your OTP to reset your password is: " + otp);
		        mailSender.send(message);
		        System.out.println("Email sent to: " + email);
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("Failed to send email: " + e.getMessage());
		    }
		}

	

		@Override
		public void sendDeliveryOtpEmail(String email, String otpStr) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
	        message.setSubject("Delivery Confirm OTP");
			message.setText("Your OTP to Confirm your Deleivery: " + otpStr);
			mailSender.send(message);			
		}

		@Override
		public void passChangeOtp(String email, String strOtp) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject("Password Change Otp");
			message.setText("Your OTP to reset password: " + strOtp);
			mailSender.send(message);
		}
}
