package com.sales.savvy.service;

public interface CartItemService {

	void deleteCart(Long id);

	void removeAfterPay(Long customerId);
}
