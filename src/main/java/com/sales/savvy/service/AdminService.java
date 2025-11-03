package com.sales.savvy.service;

import java.util.List;

import com.sales.savvy.entity.Admin;

import jakarta.mail.MessagingException;

public interface AdminService {
	Admin getByCompanyEmail(String emial);

	void emailadminSignup(AdminSignupDTO adminDto) throws MessagingException;

	void rejected(Long id);

	void approved(Long id);

	void changePasswordotp(String email);

	List<AdminOrderedProductDTO> getOrderedProducts(Long id);

	void confrimOrder(Long id);
}
