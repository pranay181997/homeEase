package com.homeease.service.repository;

import com.homeease.service.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
//    List<TimeSlot> findByServiceProviderId(Long serviceProviderId);
}
