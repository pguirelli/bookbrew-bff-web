package com.bookbrew.bff.web.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookbrew.bff.web.dto.order.OrderDTO;
import com.bookbrew.bff.web.dto.order.OrderRequestDTO;
import com.bookbrew.bff.web.dto.order.PromotionDTO;

import jakarta.validation.Valid;

@FeignClient(name = "order-service", url = "${order.service.url}")
public interface OrderServiceClient {

    @PostMapping("/promotions")
    PromotionDTO createPromotion(@Valid @RequestBody PromotionDTO promotion);

    @GetMapping("/promotions")
    List<PromotionDTO> getAllPromotions();

    @GetMapping("/promotions/{id}")
    PromotionDTO getPromotionById(@PathVariable Long id);

    @PutMapping("/promotions/{id}")
    PromotionDTO updatePromotion(@PathVariable Long id, @Valid @RequestBody PromotionDTO promotion);

    @DeleteMapping("/promotions/{id}")
    void deletePromotion(@PathVariable Long id);

    @GetMapping("/promotions/product/{productId}")
    List<PromotionDTO> getPromotionsByProduct(@PathVariable Long productId);

    // Order endpoints
    @PostMapping("/orders")
    OrderDTO createOrder(@Valid @RequestBody OrderRequestDTO orderRequest);

    @GetMapping("/orders")
    List<OrderDTO> getAllOrders();

    @GetMapping("/orders/{id}")
    OrderDTO getOrderById(@PathVariable Long id);

    @PutMapping("/orders/{orderId}")
    OrderDTO updateOrder(@PathVariable Long orderId, @RequestBody OrderRequestDTO orderRequest);

    @DeleteMapping("/orders/{orderId}")
    void deleteOrder(@PathVariable Long orderId);

}
