package com.aoct.emr.provider.bl;


import com.aoct.emr.provider.entity.ProviderEntity;
import com.aoct.emr.provider.entity.ReferringProvider;
import com.aoct.emr.provider.service.ProviderService;
import com.aoct.emr.provider.uiRequest.ProviderUIRequest;
import com.aoct.emr.provider.uiResponse.ProviderUiResponse;
import com.aoct.emr.provider.utility.ProviderHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProviderBl {

    @Autowired
    ProviderService service;

    public ReferringProvider getReferringProviderDetails(String npiNumber) {
        return service.getReferringProviderDetails(npiNumber);

    }


	public Long createProvider(ProviderUIRequest providerUIRequest) {
		
		 ProviderEntity p = ProviderHelper.convertFromProviderRequest(providerUIRequest);
		 Long providerId=service.createProvider(p);

		         return providerId;
	}


	public String searchProvider(String npiNumber) {
		return null;
	}

	public ProviderUiResponse getProviderDetail(Long providerId) {
		ProviderEntity provider=service.getProviderDetail(providerId);
		ProviderUiResponse response=ProviderHelper.convertToProviderUiResponse(provider);
		return  response;

	}

	public List<ProviderUiResponse> getAllProviderDetails() {

		List<ProviderEntity> providers=service.getAllProviderDetails();

		List<ProviderUiResponse> response=ProviderHelper.ConvertToListOfProviderUiResponse(providers);
		return  response;


	}
}

