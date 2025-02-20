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
import com.bookbrew.bff.web.dto.customer.AddressDTO;
import com.bookbrew.bff.web.dto.customer.AddressUpdateDTO;
import com.bookbrew.bff.web.dto.customer.CustomerDTO;
import com.bookbrew.bff.web.dto.customer.CustomerSearchDTO;

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
    public ResponseEntity<List<CustomerSearchDTO>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerSearchDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<CustomerSearchDTO> getCustomerByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(customerService.getCustomerByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.createCustomer(customerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerSearchDTO> updateCustomer(@PathVariable Long id,
            @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<AddressDTO> getCustomerAddressById(
            @PathVariable Long customerId,
            @PathVariable Long addressId) {
        return ResponseEntity.ok(customerService.getCustomerAddressById(customerId, addressId));
    }

    @GetMapping("/{customerId}/addresses")
    public ResponseEntity<List<AddressDTO>> getCustomerAddresses(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCustomerAddresses(customerId));
    }

    @PostMapping("/{customerId}/addresses")
    public ResponseEntity<AddressDTO> addCustomerAddress(
            @PathVariable Long customerId,
            @Valid @RequestBody AddressUpdateDTO address) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.addCustomerAddress(customerId, address));
    }

    @PutMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<AddressDTO> updateCustomerAddress(
            @PathVariable Long customerId,
            @PathVariable Long addressId,
            @Valid @RequestBody AddressUpdateDTO address) {
        return ResponseEntity.ok(customerService.updateCustomerAddress(customerId, addressId, address));
    }

    @DeleteMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<Void> deleteCustomerAddress(
            @PathVariable Long customerId,
            @PathVariable Long addressId) {
        customerService.deleteCustomerAddress(customerId, addressId);
        return ResponseEntity.noContent().build();
    }
}
