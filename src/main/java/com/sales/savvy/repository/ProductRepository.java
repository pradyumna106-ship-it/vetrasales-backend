package com.sales.savvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sales.savvy.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
