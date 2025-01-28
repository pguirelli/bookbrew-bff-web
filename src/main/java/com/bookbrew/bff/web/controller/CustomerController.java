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

import com.bookbrew.bff.web.client.CustomerServiceClient;
import com.bookbrew.bff.web.dto.customer.AddressUpdateDTO;
import com.bookbrew.bff.web.dto.customer.CustomerDTO;
import com.bookbrew.bff.web.dto.customer.CustomerUpdateDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bff/customers")
@CrossOrigin
public class CustomerController {

    private final CustomerServiceClient customerService;

    public CustomerController(CustomerServiceClient customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<ResponseEntity<List<CustomerDTO>>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.createCustomer(customerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id,
            @Valid @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<CustomerDTO> updateCustomerAddress(@PathVariable Long customerId,
            @PathVariable Long addressId, @Valid @RequestBody AddressUpdateDTO address) {
        return ResponseEntity.ok(customerService.updateCustomerAddress(customerId, addressId, address));
    }

    @DeleteMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<Void> deleteCustomerAddress(@PathVariable Long customerId, @PathVariable Long addressId) {
        customerService.deleteCustomerAddress(customerId, addressId);
        return ResponseEntity.noContent().build();
    }
}
