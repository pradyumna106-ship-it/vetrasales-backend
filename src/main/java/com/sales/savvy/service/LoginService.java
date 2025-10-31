package com.sales.savvy.service;
import dto.LoginData;
import dto.LoginResponseDTO;
public interface LoginService {
	LoginResponseDTO signin(LoginData loginData);
}
