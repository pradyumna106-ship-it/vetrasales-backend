package com.sales.savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.AddReviewDTO;
import com.sales.savvy.entity.Review;
import com.sales.savvy.service.ReviewService;
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping
public class ReviewController {
	@Autowired private ReviewService service;
	
	@GetMapping("/listOfReview")
	public List<Review> getReviews(@RequestParam("productId") Long productId) {
		return service.listOfReview(productId);
	}
	@DeleteMapping("/deleteReview")
	public String deleteReview(
	        @RequestParam Long reviewId,
	        @RequestParam String username,
	        @RequestParam(defaultValue = "false") boolean admin
	) {
	    return service.deleteReview(reviewId, username, admin);
	}

	@DeleteMapping("/deleteAllReviews")
	public String deleteAllReviews() {
	    return service.deleteAllReviews();
	}

	@DeleteMapping("/deleteReviewsByProduct")
	public ResponseEntity<String> deleteReviewsByProduct(@RequestParam Long productId) {
	    try {
	        service.deleteReviewsByProduct(productId);
	        return ResponseEntity.ok("Deleted successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body(e.getMessage());
	    }
	}
	@GetMapping("/allReviews")
	public List<AddReviewDTO> allReviews() {
		return service.allReviews();
	}
	
	
}
