package com.bookbrew.bff.web.dto.order;

import java.util.List;

import com.bookbrew.bff.web.dto.customer.AddressDTO;

public class OrderRequestDTO {

    private Long customerId;

    private List<OrderItemDTO> items;

    private String paymentMethod;

    private AddressDTO shippingAddress;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}