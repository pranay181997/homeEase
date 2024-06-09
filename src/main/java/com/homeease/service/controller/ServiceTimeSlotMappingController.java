package com.homeease.service.controller;

import com.homeease.service.model.ServiceTimeSlotMapping;
import com.homeease.service.model.TimeSlot;
import com.homeease.service.repository.ServiceTimeSlotMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/serviceTimeSlotMapping")
public class ServiceTimeSlotMappingController {
    @Autowired
    private ServiceTimeSlotMappingRepository serviceTimeSlotMappingRepository;

    @GetMapping
    public ResponseEntity<List<ServiceTimeSlotMapping>> getAllServices() {
        return ResponseEntity.ok(serviceTimeSlotMappingRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ServiceTimeSlotMapping> createService(@RequestBody ServiceTimeSlotMapping serviceTimeSlotMapping) {
        return ResponseEntity.ok(serviceTimeSlotMappingRepository.save(serviceTimeSlotMapping));
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<List<TimeSlot>> getAvailableTimeSlotForService(@PathVariable("id") Long id) {
        List<ServiceTimeSlotMapping> serviceTimeSlotMappings = serviceTimeSlotMappingRepository.findServiceTimeSlotMappingForServiceIdAndStatus(id, "AVAILABLE");
        List<TimeSlot> timeSlots = serviceTimeSlotMappings.stream().map(ServiceTimeSlotMapping::getTimeSlot).collect(Collectors.toList());
        return ResponseEntity.ok(timeSlots);
    }
}

