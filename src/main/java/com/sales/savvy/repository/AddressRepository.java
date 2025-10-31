package com.sales.savvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByCustomerId(Long id);
}
