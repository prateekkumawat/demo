package com.aoct.emr.patient.repository;


import com.aoct.emr.patient.entity.AttorneyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttorneyRepository extends JpaRepository<AttorneyEntity,Long> {
}
