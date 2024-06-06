package com.homeease.service.controller;


import com.homeease.service.model.ServiceProvider;
import com.homeease.service.model.TimeSlot;
import com.homeease.service.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/serviceProviders")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping
    public ServiceProvider createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        return serviceProviderService.saveServiceProvider(serviceProvider);
    }

    @GetMapping("/{id}/timeSlots")
    public List<TimeSlot> getAvailableTimeSlots(@PathVariable Long id) {
        return serviceProviderService.getAvailableTimeSlots(id);
    }

    @PostMapping("/{id}/timeSlots")
    public TimeSlot addTimeSlot(@PathVariable Long id, @RequestBody TimeSlot timeSlot) {
        return serviceProviderService.addTimeSlot(id, timeSlot.getStartTime(), timeSlot.getEndTime());
    }

    @GetMapping("/byService/{serviceId}")
    public List<ServiceProvider> getServiceProvidersByServiceId(@PathVariable Long serviceId) {
        return serviceProviderService.getServiceProvidersByServiceId(serviceId);
    }
}
