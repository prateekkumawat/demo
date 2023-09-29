package com.aoct.emr.patient.repository;

import com.aoct.emr.patient.entity.InjectionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InjectionTableRepo extends JpaRepository<InjectionTable,Long> {
}
