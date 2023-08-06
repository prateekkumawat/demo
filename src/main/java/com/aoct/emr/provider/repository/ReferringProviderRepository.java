package com.aoct.emr.provider.repository;

import java.util.Optional;

import com.aoct.emr.provider.entity.ReferringProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferringProviderRepository extends JpaRepository<ReferringProvider, String> {
	
	Optional<ReferringProvider> findByNpi(String npi);

}
