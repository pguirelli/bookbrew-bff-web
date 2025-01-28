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

import com.bookbrew.bff.web.client.OrderServiceClient;
import com.bookbrew.bff.web.dto.order.PromotionDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bff/promotions")
@CrossOrigin
public class PromotionController {
    private final OrderServiceClient orderServiceClient;

    public PromotionController(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }

    @PostMapping
    public ResponseEntity<PromotionDTO> createPromotion(@Valid @RequestBody PromotionDTO promotion) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderServiceClient.createPromotion(promotion));
    }

    @GetMapping
    public ResponseEntity<List<PromotionDTO>> getAllPromotions() {
        return ResponseEntity.ok(orderServiceClient.getAllPromotions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionDTO> getPromotionById(@PathVariable Long id) {
        return ResponseEntity.ok(orderServiceClient.getPromotionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionDTO> updatePromotion(@PathVariable Long id,
            @Valid @RequestBody PromotionDTO promotion) {
        return ResponseEntity.ok(orderServiceClient.updatePromotion(id, promotion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Long id) {
        orderServiceClient.deletePromotion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<PromotionDTO>> getPromotionsByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(orderServiceClient.getPromotionsByProduct(productId));
    }
}
