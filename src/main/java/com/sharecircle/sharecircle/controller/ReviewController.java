
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.entity.Review;
import com.sharecircle.sharecircle.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Integer id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUserId(
            @PathVariable Long userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    @GetMapping("/item/{itemId}")
    public List<Review> getReviewsByItemId(
            @PathVariable Integer itemId) {
        return reviewService.getReviewsByItemId(itemId);
    }

    @GetMapping("/rating/{rating}")
    public List<Review> getReviewsByRating(
            @PathVariable Integer rating) {
        return reviewService.getReviewsByRating(rating);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully!";
    }
}
