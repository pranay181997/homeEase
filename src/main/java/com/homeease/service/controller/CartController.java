package com.homeease.service.controller;

import com.homeease.service.model.Cart;
import com.homeease.service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}/add")
    public Cart addItemToCart(@PathVariable Long cartId, @RequestParam Long serviceId, @RequestParam Long serviceProviderId,
                              @RequestParam Long timeSlotId, @RequestParam String address) {
        return cartService.addItemToCart(cartId, serviceId, serviceProviderId, timeSlotId, address);
    }

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId);
    }
}
