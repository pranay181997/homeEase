package com.homeease.service.controller;

import com.homeease.service.model.ServiceProvider;
import com.homeease.service.model.ServiceServiceProviderTimeSlotMapping;
import com.homeease.service.model.ServiceTimeSlotMapping;
import com.homeease.service.model.TimeSlot;
import com.homeease.service.repository.ServiceServiceProviderTimeSlotMappingRepository;
import com.homeease.service.repository.ServiceTimeSlotMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/serviceServiceProviderTimeSlotMapping")
public class ServiceServiceProviderTimeSlotMappingController {

    @Autowired
    private ServiceServiceProviderTimeSlotMappingRepository serviceServiceProviderTimeSlotMappingRepository;

    @GetMapping
    public ResponseEntity<List<ServiceServiceProviderTimeSlotMapping>> getAllServices() {
        return ResponseEntity.ok(serviceServiceProviderTimeSlotMappingRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ServiceServiceProviderTimeSlotMapping> createService(@RequestBody ServiceServiceProviderTimeSlotMapping serviceServiceProviderTimeSlotMapping) {
        return ResponseEntity.ok(serviceServiceProviderTimeSlotMappingRepository.save(serviceServiceProviderTimeSlotMapping));
    }

    @GetMapping("/service/{serviceId}/timeSlot/{timeSlotId}")
    public ResponseEntity<ServiceProvider> getServiceProviderForServiceAndTimeSlot(@PathVariable("serviceId") Long serviceId, @PathVariable("timeSlotId") Long timeSlotId) {
        List<ServiceServiceProviderTimeSlotMapping> serviceServiceProviderTimeSlotMappings = serviceServiceProviderTimeSlotMappingRepository.findServiceProviderTimeSlot(serviceId, timeSlotId, "AVAILABLE");
        ServiceProvider serviceProvider = serviceServiceProviderTimeSlotMappings.get(0).getServiceProvider();
        return ResponseEntity.ok(serviceProvider);
    }
}
