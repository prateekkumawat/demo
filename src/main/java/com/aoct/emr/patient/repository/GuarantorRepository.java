package com.aoct.emr.patient.repository;

import com.aoct.emr.patient.entity.GuarantorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuarantorRepository extends JpaRepository<GuarantorEntity,Long> {


}
