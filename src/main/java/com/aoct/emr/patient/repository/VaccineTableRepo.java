package com.aoct.emr.patient.repository;

import com.aoct.emr.patient.entity.VaccineTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineTableRepo extends JpaRepository<VaccineTable,Long> {

}
