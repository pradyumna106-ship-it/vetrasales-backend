package com.sales.savvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.entity.Admin;
import com.sales.savvy.repository.AdminRepository;
import com.sales.savvy.repository.OrdersRepository;

import jakarta.mail.MessagingException;

@Service
public class AdminServiceImplementation implements AdminService {
	
	 @Autowired private AdminRepository admRepo;
	 @Autowired private OrdersRepository ordersRepo;
	 
	 
	@Override
	public Admin getByCompanyEmail(String emial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emailadminSignup(AdminSignupDTO adminDto) throws MessagingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejected(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approved(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePasswordotp(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdminOrderedProductDTO> getOrderedProducts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confrimOrder(Long id) {
		// TODO Auto-generated method stub
		
	}

}
