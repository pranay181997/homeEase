package com.homeease.service.service;

import com.homeease.service.model.*;
import com.homeease.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ServiceServiceProviderTimeSlotMappingRepository serviceServiceProviderTimeSlotMappingRepository;

    @Autowired
    private ServiceTimeSlotMappingRepository serviceTimeSlotMappingRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Order checkout(Long cartId, String paymentMethod) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

        for (CartItem cartItem : cart.getItems()) {
            cartItem.setStatus("BOOKED");
            cartItemRepository.save(cartItem);
            updateStatus(cartItem);
        }

        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(cart.getItems().stream().mapToDouble(item -> item.getPrice()).sum());
        payment.setStatus("COMPLETED"); // In real application, you will integrate with payment gateway
        paymentRepository.save(payment);
        Order order = new Order();
        order.setPayment(payment);
        order.setStatus("PLACED");
        order.setCart(cart);
        return orderRepository.save(order);
    }

    private void updateStatus(CartItem cartItem){
        ServiceServiceProviderTimeSlotMapping serviceServiceProviderTimeSlotMapping= serviceServiceProviderTimeSlotMappingRepository.findByServiceIdServiceProviderIdTimeSlotId(cartItem.getService().getId(),cartItem.getTimeSlot().getId(),cartItem.getServiceProvider().getId());
        serviceServiceProviderTimeSlotMapping.setStatus("BOOKED");
        serviceServiceProviderTimeSlotMappingRepository.save(serviceServiceProviderTimeSlotMapping);
        List<ServiceServiceProviderTimeSlotMapping> serviceServiceProviderTimeSlotMappingList=serviceServiceProviderTimeSlotMappingRepository.findServiceProviderTimeSlot(cartItem.getService().getId(),cartItem.getTimeSlot().getId(),"AVAILABE");
        if (serviceServiceProviderTimeSlotMappingList==null || serviceServiceProviderTimeSlotMappingList.isEmpty()){
            ServiceTimeSlotMapping serviceTimeSlotMapping= serviceTimeSlotMappingRepository.findByServiceTimeSlot(cartItem.getService().getId(),cartItem.getTimeSlot().getId());
        serviceTimeSlotMapping.setStatus("BOOKED");
        serviceTimeSlotMappingRepository.save(serviceTimeSlotMapping);
        }
    }


}
