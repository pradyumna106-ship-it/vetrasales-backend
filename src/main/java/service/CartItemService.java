package service;

public interface CartItemService {

	void deleteCart(Long id);

	void removeAfterPay(Long customerId);
}
