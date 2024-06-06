package com.homeease.service.model;


import javax.persistence.*;
import java.util.List;

public class OrderResponse {

    private List<CartItem> items;

    private Payment payment;

    private String status;

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }


    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
