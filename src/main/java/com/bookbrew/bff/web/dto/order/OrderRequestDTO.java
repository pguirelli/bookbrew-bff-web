package com.bookbrew.bff.web.dto.order;

import java.util.List;

public class OrderRequestDTO {

    private Long customerId;

    private List<OrderItemDTO> orderItems;

    private String status;

    private PaymentDTO payment;

    private Long deliveryAddress;

    private List<Long> promotionIds;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public Long getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Long deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Long> getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(List<Long> promotionIds) {
        this.promotionIds = promotionIds;
    }

}