package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.CustomerDTO;
import entity.Customer;
import repository.CustomerRepository;
@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired private CustomerRepository repo;

	@Override
	public Customer getByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void customerSignUp(CustomerDTO custdto) {
		Customer customer = new Customer();
		customer.setName(custdto.getName());
		customer.setEmail(custdto.getEmail());
		customer.setPassword(custdto.getPassword());
		// Role will be set by @PrePersist in Customer entity

		repo.save(customer);
	}
}
