package com.aoct.emr.patient.repository;

import com.aoct.emr.patient.entity.InjectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InjectionRepo extends JpaRepository<InjectionEntity,Long> {
    @Query("SELECT i from InjectionEntity i where i.patientId=:patientId")
    List<InjectionEntity> getInjectionsByPatientId(Long patientId);
}
