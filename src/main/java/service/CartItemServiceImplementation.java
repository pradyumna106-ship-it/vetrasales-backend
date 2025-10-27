package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.CartItemRepository;

@Service
public class CartItemServiceImplementation implements CartItemService {
	
	@Autowired
	CartItemRepository repo;

	@Override
	public void deleteCart(Long id) {
		// TODO Auto-generated method stub
		// Debug print to check the received ID
				System.out.println("Attempting to delete cart item with ID: " + id);

				try {
					repo.deleteById(id);
					System.out.println("Successfully deleted cart item with ID: " + id);
				} catch (Exception e) {
					System.out.println("Failed to delete cart item with ID: " + id);
					e.printStackTrace(); // This will print the full error stack trace
				}
	}

	@Override
	public void removeAfterPay(Long customerId) {
		// TODO Auto-generated method stub
		repo.deleteByCart_Customer_Id(customerId);
	}
	
}
