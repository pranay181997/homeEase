package com.homeease.service.controller;


import com.homeease.service.model.Order;
import com.homeease.service.model.OrderResponse;
import com.homeease.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout/{cartId}")
    public OrderResponse checkout(@PathVariable Long cartId, @RequestParam String paymentMethod) {
        return orderService.checkout(cartId, paymentMethod);
    }
}
