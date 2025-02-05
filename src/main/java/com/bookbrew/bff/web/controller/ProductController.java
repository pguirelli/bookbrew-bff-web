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
import com.bookbrew.bff.web.dto.product.ProductDTO;
import com.bookbrew.bff.web.dto.product.ProductImageDTO;
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
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productServiceClient.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
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

    @GetMapping("/images")
    public ResponseEntity<List<ProductImageDTO>> getAllProductImages() {
        return ResponseEntity.ok(productServiceClient.getAllProductImages());
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<ProductImageDTO> getProductImageById(@PathVariable Long id) {
        return ResponseEntity.ok(productServiceClient.getProductImageById(id));
    }

    @PostMapping("/images")
    public ResponseEntity<ProductImageDTO> createProductImage(@Valid @RequestBody ProductImageDTO productImageDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productServiceClient.createProductImage(productImageDTO));
    }

    @PutMapping("/{productId}/images/{imageId}")
    public ResponseEntity<ProductDTO> updateProductImage(@PathVariable Long productId, @PathVariable Long imageId,
            @Valid @RequestBody ProductImageDTO productImageDTO) {
        return ResponseEntity.ok(productServiceClient.updateProductImage(productId, imageId, productImageDTO));
    }

    @DeleteMapping("/{productId}/images/{imageId}")
    public ResponseEntity<Void> deleteProductImage(@PathVariable Long productId, @PathVariable Long imageId) {
        productServiceClient.deleteProductImage(productId, imageId);
        return ResponseEntity.noContent().build();
    }
}
