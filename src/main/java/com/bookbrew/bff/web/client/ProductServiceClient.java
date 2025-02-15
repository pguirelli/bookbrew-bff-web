package com.bookbrew.bff.web.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookbrew.bff.web.dto.product.BrandDTO;
import com.bookbrew.bff.web.dto.product.CategoryDTO;
import com.bookbrew.bff.web.dto.product.ProductImageDTO;
import com.bookbrew.bff.web.dto.product.ProductImagesSearchDTO;
import com.bookbrew.bff.web.dto.product.ProductRequestDTO;

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
    List<ProductRequestDTO> getAllProducts();

    @GetMapping("/{id}")
    ProductRequestDTO getProductById(@PathVariable Long id);

    @PostMapping
    ProductRequestDTO createProduct(@RequestBody ProductRequestDTO product);

    @PutMapping("/{id}")
    ProductRequestDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO productDTO);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id);

    @PostMapping(value = "/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ProductImagesSearchDTO createProductImage(@ModelAttribute ProductImageDTO productImageDTO);

}
