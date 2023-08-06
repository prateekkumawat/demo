package com.aoct.emr.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aoct.emr.provider.entity.ProviderEntity;

@Repository
public interface ProviderRepo extends JpaRepository<ProviderEntity,Long> {

}
