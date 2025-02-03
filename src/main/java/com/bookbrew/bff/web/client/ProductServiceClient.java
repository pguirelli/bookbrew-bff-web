package com.bookbrew.bff.web.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookbrew.bff.web.dto.product.BrandDTO;
import com.bookbrew.bff.web.dto.product.CategoryDTO;
import com.bookbrew.bff.web.dto.product.ProductDTO;
import com.bookbrew.bff.web.dto.product.ProductImageDTO;

import jakarta.validation.Valid;

@FeignClient(name = "product-service", url = "${product.service.url}/api/products")
public interface ProductServiceClient {

    @GetMapping("/brands")
    List<BrandDTO> getAllBrands();

    @GetMapping("/brands/{id}")
    BrandDTO getBrandById(@PathVariable Long id);

    @PostMapping("/brands")
    BrandDTO createBrand(@RequestBody BrandDTO brand);

    @PutMapping("/brands/{id}")
    BrandDTO updateBrand(@PathVariable Long id, @RequestBody BrandDTO brand);

    @DeleteMapping("/brands/{id}")
    void deleteBrand(@PathVariable Long id);

    @GetMapping("/categories")
    List<CategoryDTO> getAllCategories();

    @GetMapping("/categories/{id}")
    CategoryDTO getCategoryById(@PathVariable Long id);

    @PostMapping("/categories")
    CategoryDTO createCategory(@RequestBody CategoryDTO category);

    @PutMapping("/categories/{id}")
    CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO category);

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable Long id);

    @GetMapping
    List<ProductDTO> getAllProducts();

    @GetMapping("/{id}")
    ProductDTO getProductById(@PathVariable Long id);

    @PostMapping
    ProductDTO createProduct(@RequestBody ProductDTO product);

    @PutMapping("/{id}")
    ProductDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id);

    @GetMapping("/images")
    List<ProductImageDTO> getAllProductImages();

    @GetMapping("/images/{id}")
    ProductImageDTO getProductImageById(@PathVariable Long id);

    @PostMapping("/images")
    ProductImageDTO createProductImage(@Valid @RequestBody ProductImageDTO productImageDTO);

    @PutMapping("/{productId}/images/{imageId}")
    ProductDTO updateProductImage(@PathVariable Long productId, @PathVariable Long imageId,
            @Valid @RequestBody ProductImageDTO productImageDTO);

    @DeleteMapping("/{productId}/images/{imageId}")
    void deleteProductImage(@PathVariable Long productId, @PathVariable Long imageId);

}
