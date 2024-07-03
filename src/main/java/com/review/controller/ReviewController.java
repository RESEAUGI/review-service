package com.review.controller;

import com.review.model.Review;
import com.review.repository.ReviewRepository;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping(path = "/reviews")
    public Iterable<Review> reviewsList(){
        return reviewRepository.findAll();
    }

    @GetMapping(path = "/reviews/{id}")
    public Iterable <Review> driverReviewsList(){
        return reviewRepository.f
    }

    @PostMapping(path = "/reviews")
    public Review saveReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }
    @PutMapping(path = "/reviews/{id}")
    public Review updateReview(@PathVariable(name = "id") UUID review_id,@RequestBody Review review){
        review.setReview_id(review_id);
        return reviewRepository.save(review);
    }

    @DeleteMapping(path = "/reviews/{id}")
    public void deleteReview(@PathVariable(name = "id") UUID review_id){
        reviewRepository.deleteById(review_id);
    }
}
