package com.aoct.emr.appointment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aoct.emr.appointment.entity.AppointmentEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>{

    @Query("SELECT a FROM AppointmentEntity a WHERE a.providerId = :providerId AND a.scheduleDate = :date")
    List<AppointmentEntity> getProviderSchedule(LocalDate date, Long providerId);

    @Query("SELECT a FROM AppointmentEntity a WHERE a.scheduleDate = :date")
    List<AppointmentEntity> getProviderSchedule(LocalDate date);

    @Query("SELECT  a.scheduleDate FROM AppointmentEntity a WHERE MONTH(a.scheduleDate) = :month AND YEAR(a.scheduleDate) = :year")
    Set<LocalDate> findByMonth(int month, int year);

    @Query
   List<AppointmentEntity> findByPatientId(Long patientId);

    @Query("SELECT a FROM AppointmentEntity a WHERE a.providerId = :providerId AND MONTH(a.scheduleDate) = :month AND YEAR(a.scheduleDate) = :year")
    List<AppointmentEntity> getProviderAppointmentByMonth(Long providerId, int month, int year);
}
