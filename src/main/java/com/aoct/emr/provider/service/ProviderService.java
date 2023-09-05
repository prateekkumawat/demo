package com.aoct.emr.provider.service;




import java.util.List;

import com.aoct.emr.common.exception.DuplicateProviderException;
import com.aoct.emr.provider.entity.ProviderWorkingScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.aoct.emr.provider.entity.ProviderEntity;
import com.aoct.emr.provider.entity.ReferringProvider;
import com.aoct.emr.provider.repository.ProviderRepo;
import com.aoct.emr.provider.repository.ReferringProviderRepository;

@Service
public class ProviderService {
	
	@Autowired
	ProviderRepo providerRepo;

    @Autowired
    ReferringProviderRepository referringProviderRepo;

    public ReferringProvider getReferringProviderDetails(String npiNumber) {
        ReferringProvider referringProvider=referringProviderRepo.findByNpi(npiNumber).get();
        return referringProvider;
    }

	public Long createProvider(ProviderEntity provider) {

		
        ProviderEntity p=providerRepo.save(provider);

      if(p!=null){
          return p.getProviderId();
      }
      return null;
	}

    public ProviderEntity getProviderDetail(Long providerId) {
        ProviderEntity p=providerRepo.getById(providerId);
        if(p!=null){
            return p;
        }
        return null;

    }

    public List<ProviderEntity> getAllProviderDetails() {
        List<ProviderEntity> providers=providerRepo.findAll();
        return providers;

    }

    public List<String> getAllSpeciality() {
        return providerRepo.getAllSpeciality();
    }

    public List<ProviderEntity> getProvidersBySpeciality(String speciality) {
        return providerRepo.getProvidersBySpeciality(speciality);
    }

    public List<ProviderEntity> findProvidersByNpiAndName(String npi, String firstName, String lastName) {
       return  providerRepo.findProvidersByNpiAndName(npi, firstName, lastName);


    }


    public ProviderEntity getProviderById(Long providerId) {
        return providerRepo.getReferenceById(providerId);
    }


    public List<ProviderWorkingScheduleEntity> getProviderSchedule(Long providerId) {
        return providerRepo.getProviderSchedule(providerId);
    }
}
