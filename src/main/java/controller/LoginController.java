package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.LoginData;
import dto.LoginResponseDTO;
import service.LoginService;

@CrossOrigin("*")
@RestController
public class LoginController {
	@Autowired private LoginService service;

	@PostMapping("/signin")
	public LoginResponseDTO signin(@RequestBody LoginData loginData) {
		return service.signin(loginData);
	}
}
