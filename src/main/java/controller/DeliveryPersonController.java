package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.DeliveryConfirmedProductDTO;
import dto.DeliverySignupDTO;
import entity.DeliveryPerson;
import service.DeliveryPersonService;

import jakarta.mail.MessagingException;

@CrossOrigin("*")
@RestController
public class DeliveryPersonController {

	@Autowired
	private DeliveryPersonService service;

	@PostMapping("/deliverySignup")
	public void deliverySignup(@RequestBody DeliverySignupDTO deliveryDto) throws MessagingException {
		service.deliverySignup(deliveryDto);
		System.out.println(deliveryDto);
	}

	@GetMapping("/deliveryApproved")
	public void approved(@RequestParam Long id) {
		service.approved(id);
	}

	@GetMapping("/deliveryRejected")
	public void rejected(@RequestParam Long id) {
		service.rejected(id);
	}

	@GetMapping("/getByDeliveryEmail")
	public Optional<DeliveryPerson> getByDeliveryEmail(@RequestParam String email) {
		return service.getByDeliveryEmail(email);
	}
	
	@GetMapping("/getConfirmProduct")
	public List<DeliveryConfirmedProductDTO> getConfirmProduct(@RequestParam String email) {
		return service.getConfirmProduct(email);
	}
	
	@GetMapping("/deliveryOtp")
	public void deliveryOtp (@RequestParam Long id) {
		service.deliveryOtp(id);
	}
	
	@PostMapping("/verifyDeliveryOtp")
	public String verifyDeliveryOtp(@RequestParam Long orderId,@RequestParam Long otp) {
		System.out.println("OrderId: " + orderId);
		System.out.println("OTP: " + otp);
		return service.verifyDeliveryOtp(otp,orderId);
	}	
	
	@GetMapping("/outForDelivered")
	public String outForDelivered(@RequestParam Long orderId) {
		return service.outForDelivered(orderId);
	}
	
	@GetMapping("/delivered")
	public String deliverd(@RequestParam Long orderId) {
		return service.deliverd(orderId);
	}
	
	@GetMapping("/deliveryPerChangePasswordotp")
	public void changePassword(@RequestParam String email) {
	    service.deliveryPerChangePasswordotp(email);
	}
	
}
