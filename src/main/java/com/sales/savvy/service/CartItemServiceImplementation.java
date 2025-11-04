package com.sales.savvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.repository.CartItemRepository;

@Service
public class CartItemServiceImplementation implements CartItemService {
	@Autowired private CartItemRepository repo;
}
