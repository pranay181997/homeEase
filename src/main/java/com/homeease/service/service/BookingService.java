//package com.homeease.service.service;
//
//import com.homeease.service.model.Booking;
//import com.homeease.service.model.TimeSlot;
//import com.homeease.service.repository.BookingRepository;
//import com.homeease.service.repository.TimeSlotRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private TimeSlotRepository timeSlotRepository;
//
//    @Transactional
//    public Booking bookService(Long serviceProviderId, Long timeSlotId, String customerName, String customerAddress) {
//        Optional<TimeSlot> timeSlotOptional = timeSlotRepository.findById(timeSlotId);
//        if (!timeSlotOptional.isPresent()) {
//            throw new RuntimeException("Time slot not found");
//        }
//
//        TimeSlot timeSlot = timeSlotOptional.get();
//        if (!timeSlot.getServiceProvider().getId().equals(serviceProviderId)) {
//            throw new RuntimeException("Time slot does not belong to the specified service provider");
//        }
//
//        Booking booking = new Booking();
//        booking.setServiceProvider(timeSlot.getServiceProvider());
//        booking.setBookedTime(timeSlot.getStartTime());
//        booking.setCustomerName(customerName);
//        booking.setCustomerAddress(customerAddress);
//
//        return bookingRepository.save(booking);
//    }
//}
