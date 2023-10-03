package com.aoct.emr.patient.repository;

import com.aoct.emr.patient.entity.LabsAndProceduresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabsAndProceduresRepo extends JpaRepository<LabsAndProceduresEntity,Long> {
  @Query("SELECT l from LabsAndProceduresEntity l where l.patientId=:patientId")
    List<LabsAndProceduresEntity> getLabsAndProceduresByPatientId(Long patientId);
}
