package com.sales.savvy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.entity.Address;
import com.sales.savvy.service.AddressService;
import com.sales.savvy.dto.AddressDTO;
@CrossOrigin("*")
@RestController
public class AddressController {
	@Autowired private AddressService service;
	
	@PostMapping("/addAddress")
	public void addAddress(@RequestBody AddressDTO addressDto) {
		service.addAddress(addressDto);
	}
	
	//getting all address of the customer
	@GetMapping("/getAddress")
	public List<Address> getAddresses(@RequestParam Long customerId) {
	    return service.getAddress(customerId);
	}
	
	@GetMapping("/removeAddress")
	public void removeAddress(Long id) {
		service.removeAddress(id);
	}
	
	@GetMapping("/getAddressById")
	public Optional<Address> getAddressById(@RequestParam Long id) {
		return service.getAddressById(id);
	}
}
