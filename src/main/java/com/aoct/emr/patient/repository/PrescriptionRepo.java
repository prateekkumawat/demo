package com.aoct.emr.patient.repository;


import com.aoct.emr.patient.entity.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepo extends JpaRepository<PrescriptionEntity,Long> {

    @Query("SELECT p from PrescriptionEntity p where p.patientId=:patientId")
    List<PrescriptionEntity> getPrescriptionByPatientId(Long patientId);
}
