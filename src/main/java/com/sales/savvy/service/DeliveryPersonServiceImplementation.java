package com.sales.savvy.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DeliveryConfirmedProductDTO;
import dto.DeliverySignupDTO;
import entity.Customer;
import entity.CustomerDeliveryOtp;
import entity.DeliveryPerPassChangeOtp;
import entity.DeliveryPerson;
import entity.OrderItem;
import entity.Orders;
import entity.Product;
import repository.CustomerDeliveryOtpRepository;
import repository.CustomerRepository;
import repository.DeliveryPerPassChangeOtpRepository;
import repository.DeliveryPersonRepository;
import repository.OrdersRepository;

import jakarta.mail.MessagingException;

@Service
public class DeliveryPersonServiceImplementation implements DeliveryPersonService {
	@Autowired private DeliveryPersonRepository repo;

	@Autowired private EmailService eservice;

	@Autowired private OrdersRepository ordersRepo;

	@Autowired private CustomerRepository cusRepo;

	@Autowired private CustomerDeliveryOtpRepository delOtpRepo;
	
	@Autowired private DeliveryPerPassChangeOtpRepository delpassRepo;
	
	@Autowired private OtpServiceImplementation otpService;
	@Override
	public void deliverySignup(DeliverySignupDTO deliveryDto) throws MessagingException {
		eservice.processDeliverySignup(deliveryDto);
	}

	@Override
	public void approved(Long id) {
		eservice.delapproved(id);
	}

	@Override
	public void rejected(Long id) {
		eservice.delrejected(id);
	}

	@Override
	public Optional<DeliveryPerson> getByDeliveryEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<DeliveryConfirmedProductDTO> getConfirmProduct(String email) {
		Optional<DeliveryPerson> person = repo.findByEmail(email);

		if (person.isEmpty()) {
			throw new RuntimeException("Delivery person not found with email: " + email);
		}

		List<Orders> orders = ordersRepo.findByDeliveryPersonId(person.get().getId());
		List<DeliveryConfirmedProductDTO> dtoList = new ArrayList<>();

		for (Orders order : orders) {
			for (OrderItem item : order.getItems()) {
				Product product = item.getProduct();

				DeliveryConfirmedProductDTO dto = new DeliveryConfirmedProductDTO(order.getId(), order.getOrdertime(),
						order.getTotAmount(), order.getStatus(), product.getId(), product.getProductName(),
						product.getProductImage(), item.getQuantity(), order.getAddress());
				dtoList.add(dto);
			}

		}

		return dtoList;
	}

	@Override
	public void deliveryOtp(Long id) {
		Optional<Orders> orderOptional = ordersRepo.findById(id);

		Orders order = orderOptional.get();

		Customer customer = order.getCustomer();

		String email = customer.getEmail();

		// Generate 6-digit OTP
		Random random = new Random();
		int otp = random.nextInt(900000) + 100000;
		String otpStr = String.valueOf(otp);

		CustomerDeliveryOtp delotp = new CustomerDeliveryOtp();
		delotp.setOtp(otpStr);
		delotp.setOrderId(id);

		delOtpRepo.save(delotp);

		// Send email
		eservice.sendDeliveryOtpEmail(email, otpStr);

	}

	@Override
	public String verifyDeliveryOtp(Long otp, Long orderId) {
		Optional<CustomerDeliveryOtp> otpOptional = delOtpRepo.findByOrderId(orderId);

		if (otpOptional.isPresent()) {
			CustomerDeliveryOtp storedOtp = otpOptional.get();

			if (storedOtp.getOtp().equals(String.valueOf(otp))) {
				delOtpRepo.delete(storedOtp);
				return "OTP verified successfully!";
				
			} else {	
				return "Invalid OTP!";
			}
		} else {
			return "OTP not found for this order.";
		}
	}

	@Override
	public String deliverd(Long orderId) {
		Optional<Orders> order = ordersRepo.findById(orderId);
		Orders exsistOrder = order.get();
		exsistOrder.setStatus("DELIVERED");
		ordersRepo.save(exsistOrder);
		return "DELIVERED SUCCESSFULLY....";
	}

	@Override
	public String outForDelivered(Long orderId) {
		Optional<Orders> order = ordersRepo.findById(orderId);
		Orders exsistOrder = order.get();
		exsistOrder.setStatus("OUT FOR DELIVERED");
		ordersRepo.save(exsistOrder);
		return "OUT FOR DELIVERY SUCCESSFULLY....";
	}

	@Override
	public void deliveryPerChangePasswordotp(String email) {
		Optional<DeliveryPerson> delPer = repo.findByEmail(email);
		otpService.sendDeliveryPerChangePassword(email);
		
	}
}
