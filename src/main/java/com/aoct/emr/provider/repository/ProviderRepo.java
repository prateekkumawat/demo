package com.aoct.emr.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aoct.emr.provider.entity.ProviderEntity;

import java.util.List;

@Repository
public interface ProviderRepo extends JpaRepository<ProviderEntity,Long> {

    @Query("SELECT DISTINCT p.speciality FROM ProviderEntity p")
     List<String> getAllSpeciality();

    @Query("SELECT p FROM ProviderEntity p WHERE p.speciality = :speciality")
    List<ProviderEntity> getProvidersBySpeciality(String speciality);
}
