package com.sales.savvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.repository.CartItemRepository;

import jakarta.transaction.Transactional;

@Service
public class CartItemServiceImplementation implements CartItemService {
	@Autowired private CartItemRepository repo;

	@Transactional
	public String removeItem(Long id) {
		// TODO Auto-generated method stub
		repo.deleteByProduct_Id(id);
		return "success";
	}
	
}
