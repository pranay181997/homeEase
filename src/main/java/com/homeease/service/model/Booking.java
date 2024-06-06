//package com.homeease.service.model;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class Booking {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "service_id")
//    private Service service;
//
//    @ManyToOne
//    @JoinColumn(name = "service_provider_id")
//    private ServiceProvider serviceProvider;
//
//    private LocalDateTime bookedTime;
//
//    private String customerName;
//
//    private String customerAddress;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }
//
//    public ServiceProvider getServiceProvider() {
//        return serviceProvider;
//    }
//
//    public void setServiceProvider(ServiceProvider serviceProvider) {
//        this.serviceProvider = serviceProvider;
//    }
//
//    public LocalDateTime getBookedTime() {
//        return bookedTime;
//    }
//
//    public void setBookedTime(LocalDateTime bookedTime) {
//        this.bookedTime = bookedTime;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//}
