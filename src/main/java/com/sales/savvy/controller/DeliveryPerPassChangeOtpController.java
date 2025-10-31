package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.service.DeliveryPerPassChangeOtpService;

@CrossOrigin("*")
@RestController
public class DeliveryPerPassChangeOtpController {

	@Autowired private DeliveryPerPassChangeOtpService service;
	
}