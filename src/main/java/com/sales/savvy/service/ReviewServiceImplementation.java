package com.sales.savvy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.AddReviewDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.Review;
import com.sales.savvy.repository.ProductRepository;
import com.sales.savvy.repository.ReviewRepository;
@Service
public class ReviewServiceImplementation implements ReviewService {
	@Autowired private ReviewRepository repo;
	
	@Override
	public List<Review> listOfReview(Long productId) {
		// TODO Auto-generated method stub
		return repo.findByProduct_Id(productId);
	}
	@Override
	public String deleteReview(Long reviewId, String username, boolean isAdmin) {
		// TODO Auto-generated method stub
		Review r = repo.findById(reviewId).orElse(null);

        if (r == null) return "Review Not Found";

        // If not admin → only delete his own review
        if (!isAdmin && !r.getCustomerName().equals(username)) {
            return "You can delete only your own reviews!";
        }

        repo.deleteById(reviewId);
        return "deleted";
	}
	@Override
	public String deleteAllReviews() {
		// TODO Auto-generated method stub
		repo.deleteAll();
        return "all_deleted";
	}
	@Override
	public String deleteReviewsByProduct(Long productId) {
		// TODO Auto-generated method stub
		repo.deleteByProduct_Id(productId);
        return "deleted_by_product";
	}
	@Override
	public List<AddReviewDTO> allReviews() {
		// TODO Auto-generated method stub
		List<Review> reviews = repo.findAll();
		List<AddReviewDTO> dtos = new ArrayList<>();
		for (int i = 0; i < reviews.size(); i++) {
			Review review = reviews.get(i);
			AddReviewDTO dto = new AddReviewDTO();
			dto.setComment(review.getComment());
			dto.setProductName(review.getProduct().getName());;
			dto.setRating(review.getRating());
			dto.setCustomerName(review.getCustomerName());
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	


}
