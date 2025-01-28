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
import com.bookbrew.bff.web.dto.order.OrderDTO;
import com.bookbrew.bff.web.dto.order.OrderRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bff/orders")
@CrossOrigin
public class OrderController {
    private final OrderServiceClient orderServiceClient;

    public OrderController(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderRequestDTO orderRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderServiceClient.createOrder(orderRequest));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderServiceClient.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderServiceClient.getOrderById(id));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long orderId, @RequestBody OrderRequestDTO orderRequest) {
        return ResponseEntity.ok(orderServiceClient.updateOrder(orderId, orderRequest));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderServiceClient.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
