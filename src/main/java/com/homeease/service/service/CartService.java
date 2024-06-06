package com.homeease.service.service;

import com.homeease.service.model.Cart;
import com.homeease.service.model.CartItem;
import com.homeease.service.model.ServiceProvider;
import com.homeease.service.model.TimeSlot;
import com.homeease.service.repository.CartRepository;
import com.homeease.service.repository.ServiceProviderRepository;
import com.homeease.service.repository.ServiceRepository;
import com.homeease.service.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public Cart addItemToCart(Long cartId, Long serviceId, Long serviceProviderId, Long timeSlotId, String address) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());

        com.homeease.service.model.Service service = serviceRepository.findById(serviceId).orElseThrow(() -> new RuntimeException("Service not found"));
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderId).orElseThrow(() -> new RuntimeException("Service provider not found"));
        TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId).get();
        if (timeSlot.getStatus()!=null && "BOOKED".equalsIgnoreCase(timeSlot.getStatus())) {
            throw new RuntimeException("Select other time slot");
        }
        CartItem cartItem = new CartItem();
        cartItem.setService(service);
        cartItem.setServiceProvider(serviceProvider);
        cartItem.setTimeSlot(timeSlot);
        cartItem.setAddress(address);
        cartItem.setPrice(service.getPrice());
        if (cart.getItems() == null) {
            cart.setItems(new ArrayList<>());
        }
        cart.getItems().add(cartItem);
        timeSlot.setStatus("ADDED_TO_CART");
        timeSlotRepository.save(timeSlot);
        return cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}
