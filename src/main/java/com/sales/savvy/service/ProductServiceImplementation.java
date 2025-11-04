package com.sales.savvy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.User;
import com.sales.savvy.repository.ProductRepository;
import com.sales.savvy.repository.UserRepository;
@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired	
	private ProductRepository repo;
	@Autowired private UserRepository userRepo;
	@Override
	public void addProduct(ProductDTO prod) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setId(prod.getId());
		product.setName(prod.getName());
		product.setDescription(prod.getDescription());
		product.setImage(prod.getImage());
		product.setPrice(prod.getPrice());
		Optional<User> admin = userRepo.findById(prod.getAdminId());
		product.setAdmin(admin.get());
		repo.save(product);
		
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		// TODO Auto-generated method stub
		List<Product> result = repo.searchProduct(keyword);
		return result;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void updateProduct(ProductDTO prod) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setId(prod.getId());
		product.setName(prod.getName());
		product.setDescription(prod.getDescription());
		product.setImage(prod.getImage());
		product.setPrice(prod.getPrice());
		Optional<User> admin = userRepo.findById(prod.getAdminId());
		product.setAdmin(admin.get());
		repo.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
