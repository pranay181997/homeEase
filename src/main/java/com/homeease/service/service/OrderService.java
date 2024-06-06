package com.homeease.service.service;

import com.homeease.service.model.*;
import com.homeease.service.repository.CartRepository;
import com.homeease.service.repository.OrderRepository;
import com.homeease.service.repository.PaymentRepository;
import com.homeease.service.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public OrderResponse checkout(Long cartId, String paymentMethod) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.getItems().forEach(cartItem -> {
            TimeSlot timeSlot = cartItem.getTimeSlot();
            if(timeSlot!=null){
            timeSlot.setStatus("BOOKED");
            timeSlotRepository.save(timeSlot);}
        });

        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(cart.getItems().stream().mapToDouble(item -> item.getPrice()).sum());
        payment.setStatus("COMPLETED"); // In real application, you will integrate with payment gateway
        paymentRepository.save(payment);
        Order order = new Order();
        order.setItems(cart.getItems());
        order.setPayment(payment);
        order.setStatus("PLACED");


        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setItems(cart.getItems());
        orderResponse.setPayment(payment);
        orderResponse.setStatus("PLACED");

//        cartRepository.delete(cart);

         return orderResponse;
    }
}
