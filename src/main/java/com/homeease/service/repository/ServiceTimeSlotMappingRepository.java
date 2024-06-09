package com.homeease.service.repository;

import com.homeease.service.model.ServiceTimeSlotMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceTimeSlotMappingRepository extends JpaRepository<ServiceTimeSlotMapping, Long> {

    @Query("SELECT st FROM ServiceTimeSlotMapping st WHERE st.service.id = :serviceId AND st.status= :status")
    List<ServiceTimeSlotMapping> findServiceTimeSlotMappingForServiceIdAndStatus(@Param("serviceId") Long serviceId, @Param("status") String status);

    @Query("SELECT st FROM ServiceTimeSlotMapping st WHERE st.service.id = :serviceId AND st.timeSlot.id= :timeSlotId")
    ServiceTimeSlotMapping findByServiceTimeSlot(@Param("serviceId") Long serviceId, @Param("timeSlotId") Long timeSlotId);

    @Query("Update ServiceTimeSlotMapping st set st.status= :status  WHERE st.service.id = :serviceId AND st.timeSlot.id = :timeSlotId")
    ServiceTimeSlotMapping updateStatus(@Param("serviceId") Long serviceId, @Param("timeSlotId") Long timeSlotId, @Param("status") String status);

}
