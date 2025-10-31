package com.sales.savvy.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByEmail(String email);

	Optional<Customer> findById(Customer customerId);
}
