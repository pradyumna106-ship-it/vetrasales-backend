package com.sales.savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin getByCompanyEmail(String email);
}
