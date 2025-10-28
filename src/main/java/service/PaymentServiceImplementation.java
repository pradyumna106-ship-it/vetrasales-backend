package service;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.PaymentDTO;
import entity.Customer;
import entity.Payment;
import repository.CustomerRepository;
import repository.PaymentRepository;
@Service
public class PaymentServiceImplementation implements PaymentService {
	@Autowired private PaymentRepository repo;

	@Autowired private CustomerRepository cusrepo;
	
	@Override
	public void savePayment(PaymentDTO payDto) {
		Payment payment = new Payment();
		payment.setAmount(payDto.getAmount());
		payment.setEmail(payDto.getEmail());
		payment.setPaymentId(payDto.getPaymentId());
		payment.setPaymentDate(LocalDateTime.now());

		Customer customer = cusrepo.findByEmail(payDto.getEmail());
		payment.setCustomer(customer);
		repo.save(payment);
	}
	
}
