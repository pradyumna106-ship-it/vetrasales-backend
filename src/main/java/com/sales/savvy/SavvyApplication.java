package com.sales.savvy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sales.savvy")
public class SavvyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavvyApplication.class, args);
	}

}
