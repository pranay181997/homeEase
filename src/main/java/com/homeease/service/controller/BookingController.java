//package com.homeease.service.controller;
//
//
//import com.homeease.service.model.Booking;
//import com.homeease.service.service.BookingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/bookings")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @PostMapping
//    public Booking bookService(@RequestParam Long serviceProviderId, @RequestParam Long timeSlotId,
//                               @RequestParam String customerName, @RequestParam String customerAddress) {
//        return bookingService.bookService(serviceProviderId, timeSlotId, customerName, customerAddress);
//    }
//}
