package com.aoct.emr.provider.bl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoct.emr.common.exception.InvalidNpiException;
import com.aoct.emr.provider.entity.ProviderEntity;
import com.aoct.emr.provider.entity.ReferringProvider;
import com.aoct.emr.provider.externalResponseModel.ExternalServiceResponseModel;
import com.aoct.emr.provider.service.ExternalService;
import com.aoct.emr.provider.service.ProviderService;
import com.aoct.emr.provider.uiRequest.ProviderUIRequest;
import com.aoct.emr.provider.uiResponse.ProviderUiResponse;
import com.aoct.emr.provider.utility.ProviderHelper;

@Component
public class ProviderBl {

    @Autowired
    ProviderService service;
    
    @Autowired
    ExternalService externalService;

    public ReferringProvider getReferringProviderDetails(String npiNumber) {
        return service.getReferringProviderDetails(npiNumber);

    }


	public Long createProvider(ProviderUIRequest providerUIRequest) {
			 
		 ExternalServiceResponseModel externalNpiCallResponse = externalService.callExternalNpiAPi(providerUIRequest.getNpi());
		 if(externalNpiCallResponse.getResults().size()<1)
		 {
			 throw new InvalidNpiException("NPI number does not exist.Please retry with correct NPI");
		 }
		ProviderUIRequest providerRequest = ProviderHelper.checkConflictAddProvider(providerUIRequest,externalNpiCallResponse);
		ProviderEntity p = ProviderHelper.convertFromProviderRequest(providerRequest);
		// ProviderEntity p = ProviderHelper.convertFromProviderRequest(providerUIRequest); //to be deleted
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


	public List<String> getAllSpeciality() {

		return service.getAllSpeciality();
	}

	public List<ProviderUiResponse> getProvidersBySpeciality(String speciality) {
		List<ProviderEntity> providers=service.getProvidersBySpeciality(speciality);
		List<ProviderUiResponse> response=ProviderHelper.ConvertToListOfProviderUiResponse(providers);
		return  response;
	}
}

