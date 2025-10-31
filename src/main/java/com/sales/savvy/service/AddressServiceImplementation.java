package com.sales.savvy.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.AddressDTO;
import com.sales.savvy.entity.Address;
import com.sales.savvy.entity.Customer;
import com.sales.savvy.repository.AddressRepository;
import com.sales.savvy.repository.CustomerRepository;

@Service
public class AddressServiceImplementation implements AddressService {
	@Autowired private AddressRepository addrRepo;

	@Autowired private CustomerRepository cusRepo;

	@Override
	public void addAddress(AddressDTO addressDto) {
		Address addr = new Address();

		Customer customer = cusRepo.findByEmail(addressDto.getEmail());
		addr.setCustomer(customer);
		addr.setFullName(addressDto.getFullName());
		addr.setPhone(addressDto.getPhone());
		addr.setPincode(addressDto.getPincode());
		addr.setStreet(addressDto.getStreet());
		addr.setCity(addressDto.getCity());
		addr.setState(addressDto.getState());
		addr.setLandmark(addressDto.getLandmark());
		addr.setType(addressDto.getType());
		System.out.println(addr);
		addrRepo.save(addr);
	}

	@Override
	public List<Address> getAddress(Long customerId) {
		return addrRepo.findByCustomerId(customerId);
	}

	@Override
	public void removeAddress(Long id) {
		addrRepo.deleteById(id);
	}

	@Override
	public Optional<Address> getAddressById(Long id) {
		return addrRepo.findById(id);
	}
}
