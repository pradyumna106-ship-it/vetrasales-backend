package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.LoginData;
import dto.LoginResponseDTO;
import entity.Admin;
import entity.Customer;
import entity.DeliveryPerson;

@Service
public class LoginServiceImplementation implements LoginService {
	@Autowired private AdminService adService;

	@Autowired private CustomerService cusService;

	@Autowired private DeliveryPersonService delService;

	@Override
	public LoginResponseDTO signin(LoginData loginData) {
		Admin admin = adService.getByCompanyEmail(loginData.getEmail());
		Customer cus = cusService.getByEmail(loginData.getEmail());
		Optional<DeliveryPerson> del = delService.getByDeliveryEmail(loginData.getEmail());
		if (admin != null && admin.getCompanyEmail().equals(loginData.getEmail())
				&& admin.getPassword().equals(loginData.getPassword())) {
			System.out.println("Admin login: id=" + admin.getId() + ", email=" + admin.getCompanyEmail());
			return new LoginResponseDTO("admin", admin.getId(), admin.getCompanyEmail());

		} else if (cus != null && cus.getEmail().equals(loginData.getEmail())
				&& cus.getPassword().equals(loginData.getPassword())) {

			return new LoginResponseDTO("customer", cus.getId(), cus.getEmail());
		} else if (del.isPresent() && del.get().getEmail().equals(loginData.getEmail())
		        && del.get().getPassword().equals(loginData.getPassword())) {
		    return new LoginResponseDTO("delivery", del.get().getId(), del.get().getEmail());
		}

		return null;
	}
}
