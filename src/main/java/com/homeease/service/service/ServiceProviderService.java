package com.homeease.service.service;


import com.homeease.service.model.ServiceProvider;
import com.homeease.service.model.TimeSlot;
import com.homeease.service.repository.ServiceProviderRepository;
import com.homeease.service.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    public List<ServiceProvider> getServiceProvidersByServiceId(Long serviceId) {
        return serviceProviderRepository.findServiceProvidersByServiceId(serviceId);
    }

    public List<TimeSlot> getAvailableTimeSlots(Long serviceProviderId) {
        return timeSlotRepository.findByServiceProviderId(serviceProviderId);
    }

    public TimeSlot addTimeSlot(Long serviceProviderId, LocalDateTime startTime, LocalDateTime endTime) {
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderId).orElseThrow(() -> new RuntimeException("Service provider not found"));

        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setServiceProvider(serviceProvider);
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);

        return timeSlotRepository.save(timeSlot);
    }
}

