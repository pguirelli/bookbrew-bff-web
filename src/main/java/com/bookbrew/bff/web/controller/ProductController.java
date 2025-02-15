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
import com.bookbrew.bff.web.dto.product.ProductRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bff/products")
@CrossOrigin
public class ProductController {
    private final ProductServiceClient productServiceClient;

    public ProductController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping
    public ResponseEntity<List<ProductRequestDTO>> getAllProducts() {
        return ResponseEntity.ok(productServiceClient.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRequestDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productServiceClient.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductRequestDTO> createProduct(@Valid @RequestBody ProductRequestDTO product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productServiceClient.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductRequestDTO> updateProduct(@PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO productDTO) {
        return ResponseEntity.ok(productServiceClient.updateProduct(id, productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productServiceClient.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
