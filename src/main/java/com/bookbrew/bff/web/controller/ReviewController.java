package com.bookbrew.bff.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookbrew.bff.web.client.ProductServiceClient;
import com.bookbrew.bff.web.dto.product.ProductReviewDTO;
import com.bookbrew.bff.web.dto.product.ProductReviewRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bff/reviews")
@CrossOrigin
public class ReviewController {
    private final ProductServiceClient reviewServiceClient;

    public ReviewController(ProductServiceClient reviewServiceClient) {
        this.reviewServiceClient = reviewServiceClient;
    }

    @GetMapping
    public ResponseEntity<List<ProductReviewDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewServiceClient.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductReviewDTO> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewServiceClient.getReviewById(id));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductReviewDTO>> getReviewsByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewServiceClient.getReviewsByProduct(productId));
    }

    @PostMapping
    public ResponseEntity<ProductReviewDTO> createReview(@Valid @RequestBody ProductReviewRequestDTO reviewRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewServiceClient.createReview(reviewRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductReviewDTO> updateReview(@PathVariable Long id,
            @Valid @RequestBody ProductReviewRequestDTO reviewRequest) {
        return ResponseEntity.ok(reviewServiceClient.updateReview(id, reviewRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewServiceClient.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
