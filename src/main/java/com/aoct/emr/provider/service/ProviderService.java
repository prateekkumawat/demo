package com.aoct.emr.provider.service;


import com.aoct.emr.provider.entity.ProviderEntity;
import com.aoct.emr.provider.entity.ReferringProvider;
import com.aoct.emr.provider.repository.ProviderRepo;
import com.aoct.emr.provider.repository.ReferringProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public String createProvider(ProviderEntity provider) {
		
        ProviderEntity p=providerRepo.save(provider);

        if(p==null){

            return null;

        }

        else{

            return p.getProviderId();

        }
	}

    public ProviderEntity getProviderDetail(String providerId) {
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
}
