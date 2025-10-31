package com.sales.savvy.service;

import java.util.List;
import java.util.Optional;

import com.sales.savvy.dto.AddressDTO;
import com.sales.savvy.entity.Address;
public interface AddressService {
	void addAddress(AddressDTO addressDto);

	List<Address> getAddress(Long customerId);

	void removeAddress(Long id);

	Optional<Address> getAddressById(Long id);
}
