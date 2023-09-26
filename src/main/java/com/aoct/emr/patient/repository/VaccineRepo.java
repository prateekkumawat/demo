package com.aoct.emr.patient.repository;

import com.aoct.emr.patient.entity.VaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<VaccineEntity,Long> {
   @Query("SELECT v from VaccineEntity v where v.patientId=:patientId")
   List<VaccineEntity> getVaccinesByPatientId(Long patientId);
}
