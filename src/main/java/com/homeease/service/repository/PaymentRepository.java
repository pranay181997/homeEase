package com.homeease.service.repository;

import com.homeease.service.model.Order;
import com.homeease.service.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
