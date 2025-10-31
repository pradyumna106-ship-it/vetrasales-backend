package com.sales.savvy.service;


import dto.CustomerDTO;
import entity.Customer;

public interface CustomerService {

	void customerSignUp(CustomerDTO custdto);

	Customer getByEmail(String emial);
}
