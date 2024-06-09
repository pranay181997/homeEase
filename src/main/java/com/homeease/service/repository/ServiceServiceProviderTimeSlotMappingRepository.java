package com.homeease.service.repository;

import com.homeease.service.model.ServiceServiceProviderTimeSlotMapping;
import com.homeease.service.model.ServiceTimeSlotMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceServiceProviderTimeSlotMappingRepository extends JpaRepository<ServiceServiceProviderTimeSlotMapping, Long> {
    @Query("SELECT sst FROM ServiceServiceProviderTimeSlotMapping sst WHERE sst.service.id = :serviceId AND sst.timeSlot.id = :timeSlotId AND sst.status= :status")
    List<ServiceServiceProviderTimeSlotMapping> findServiceProviderTimeSlot(@Param("serviceId") Long serviceId, @Param("timeSlotId") Long timeSlotId, @Param("status") String status);

    @Query("SELECT sst FROM ServiceServiceProviderTimeSlotMapping sst WHERE sst.service.id = :serviceId AND sst.timeSlot.id = :timeSlotId AND sst.serviceProvider.id= :serviceProviderId")
    ServiceServiceProviderTimeSlotMapping findByServiceIdServiceProviderIdTimeSlotId(@Param("serviceId") Long serviceId, @Param("timeSlotId") Long timeSlotId, @Param("serviceProviderId") Long serviceProviderId);

    @Query("Update ServiceServiceProviderTimeSlotMapping sst set sst.status= :status  WHERE sst.service.id = :serviceId AND sst.timeSlot.id = :timeSlotId AND sst.serviceProvider.id= :serviceProviderId")
    ServiceServiceProviderTimeSlotMapping updateStatus(@Param("serviceId") Long serviceId, @Param("timeSlotId") Long timeSlotId, @Param("status") String status,@Param("serviceProviderId") Long serviceProviderId);
}
