package com.sales.savvy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.ReviewDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.Review;
import com.sales.savvy.repository.ProductRepository;
import com.sales.savvy.repository.ReviewRepository;
@Service
public class ReviewServiceImplementation implements ReviewService {
	@Autowired private ReviewRepository repo;
	
	@Override
	public List<ReviewDTO> listOfReview(Long productId) {
		// TODO Auto-generated method stub
		List<Review> reviews = repo.findByProduct_Id(productId);
		List<ReviewDTO> dtos = new ArrayList<>();
		for (int i = 0; i < reviews.size(); i++) {
			Review review = reviews.get(i);
			ReviewDTO dto = new ReviewDTO();
			dto.setComment(review.getComment());
			dto.setProductId(review.getProduct().getId());;
			dto.setRating(review.getRating());
			dto.setCustomerName(review.getCustomerName());
			dtos.add(dto);
		}
		
		return dtos;
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
	public List<ReviewDTO> allReviews() {
		// TODO Auto-generated method stub
		List<Review> reviews = repo.findAll();
		List<ReviewDTO> dtos = new ArrayList<>();
		for (int i = 0; i < reviews.size(); i++) {
			Review review = reviews.get(i);
			ReviewDTO dto = new ReviewDTO();
			dto.setComment(review.getComment());
			dto.setProductId(review.getProduct().getId());
			dto.setRating(review.getRating());
			dto.setCustomerName(review.getCustomerName());
			dto.setId(review.getId());
			dto.setStatus(review.getStatus().toString());
			dto.setDate(review.getDate());
			dtos.add(dto);
		}
		
		return dtos;
	}
	@Override
	public List<ReviewDTO> listofCustomerReview(String username) {
		// TODO Auto-generated method stub
		List<Review> reviews = repo.findByCustomerName(username);
		List<ReviewDTO> dtos = new ArrayList<>();
		for (int i = 0; i < reviews.size(); i++) {
			Review review = reviews.get(i);
			ReviewDTO dto = new ReviewDTO();
			dto.setComment(review.getComment());
			dto.setProductId(review.getProduct().getId());
			dto.setRating(review.getRating());
			dto.setCustomerName(review.getCustomerName());
			dto.setId(review.getId());
			dto.setStatus(review.getStatus().toString());
			dto.setDate(review.getDate());
			dtos.add(dto);
		}
		return dtos;
	}
	
	


}
