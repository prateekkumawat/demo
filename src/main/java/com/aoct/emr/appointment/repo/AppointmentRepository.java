package com.aoct.emr.appointment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aoct.emr.appointment.entity.AppointmentEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>{

    @Query("SELECT a FROM AppointmentEntity a WHERE a.providerId = :providerId AND a.scheduleDate = :date")
    List<AppointmentEntity> getProviderSchedule(LocalDate date, Long providerId);
}
