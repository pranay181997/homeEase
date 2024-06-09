package com.homeease.service.repository;

import com.homeease.service.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    @Query("SELECT sp FROM ServiceProvider sp WHERE sp.id = :serviceId")
    List<ServiceProvider> findServiceProvidersByServiceId(@Param("serviceId") Long serviceId);
}