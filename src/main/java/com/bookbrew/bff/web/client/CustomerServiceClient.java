package com.bookbrew.bff.web.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookbrew.bff.web.dto.customer.AddressUpdateDTO;
import com.bookbrew.bff.web.dto.customer.CustomerDTO;
import com.bookbrew.bff.web.dto.customer.CustomerUpdateDTO;

import jakarta.validation.Valid;

@FeignClient(name = "customer-service", url = "${customer.service.url}/api/customers")
public interface CustomerServiceClient {

    @GetMapping
    ResponseEntity<List<CustomerDTO>> getAllCustomers();

    @GetMapping("/{id}")
    CustomerDTO getCustomerById(@PathVariable Long id);

    @PostMapping
    CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO);

    @PutMapping("/{id}")
    CustomerDTO updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerUpdateDTO customerUpdateDTO);

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id);

    @PutMapping("/{customerId}/addresses/{addressId}")
    CustomerDTO updateCustomerAddress(@PathVariable Long customerId, @PathVariable Long addressId,
            @Valid @RequestBody AddressUpdateDTO address);

    @DeleteMapping("/{customerId}/addresses/{addressId}")
    void deleteCustomerAddress(@PathVariable Long customerId, @PathVariable Long addressId);
}
