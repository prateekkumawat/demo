package com.aoct.emr.provider.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aoct.emr.provider.entity.ProviderEntity;
import com.aoct.emr.provider.externalResponseModel.ExternalServiceResponseModel;
import com.aoct.emr.provider.uiRequest.ProviderUIRequest;
import com.aoct.emr.provider.uiResponse.ProviderUiResponse;

public class ProviderHelper {

	public static ProviderEntity convertFromProviderRequest(ProviderUIRequest providerUIRequest) {
		
		ProviderEntity p = new ProviderEntity();
		
		p.setFirstName(providerUIRequest.getFirstName());
		p.setLastName(providerUIRequest.getLastName());
		p.setPrefix(providerUIRequest.getPrefix());
		p.setDegree(providerUIRequest.getDegree());
		p.setDateOfBirth(providerUIRequest.getDateOfBirth());
		p.setSsn(providerUIRequest.getSsn());
		p.setGender(providerUIRequest.getGender());
		p.setEmail(providerUIRequest.getEmail());
		p.setAddressLine1(providerUIRequest.getAddressLine1());
		p.setAddressLine2(providerUIRequest.getAddressLine2());
		p.setCity(providerUIRequest.getCity());
		p.setState(providerUIRequest.getState());
		p.setZipCode(providerUIRequest.getZipCode());
		p.setPrimaryNumber(providerUIRequest.getPrimaryNumber());
		p.setSecondaryNumber(providerUIRequest.getSecondaryNumber());
		p.setPrimaryPracticeLocation(providerUIRequest.getPrimaryPracticeLocation());
		p.setPagerCode(providerUIRequest.getPagerCode());
		p.setTaxonomyCode(providerUIRequest.getTaxonomyCode());
		p.setDeaNumber(providerUIRequest.getDeaNumber());
		p.setDeaStartDate(providerUIRequest.getDeaStartDate());
		p.setDeaEndDate(providerUIRequest.getDeaEndDate());
		p.setNpi(providerUIRequest.getNpi());
		p.setSpecialLicense(providerUIRequest.getSpecialLicense());
		p.setSpecialLicenseStartDate(providerUIRequest.getSpecialLicenseStartDate());
		p.setSpecialLicenseEndDate(providerUIRequest.getSpecialLicenseEndDate());
		p.setLicensingState(providerUIRequest.getLicensingState());
		p.setTaxId(providerUIRequest.getTaxId());
		p.setTaxIdType(providerUIRequest.getTaxIdType());
		p.setSendProviderCredentials(providerUIRequest.isSendProviderCredentials());
		
		return p;
	}

	public static ProviderUiResponse convertToProviderUiResponse(ProviderEntity provider) {
	ProviderUiResponse uiResponse=new ProviderUiResponse();
		uiResponse.setProviderId(provider.getProviderId());
		uiResponse.setFirstName(provider.getFirstName());
		uiResponse.setLastName(provider.getLastName());
		uiResponse.setPrefix(provider.getPrefix());
		uiResponse.setDegree(provider.getDegree());
		uiResponse.setDateOfBirth(provider.getDateOfBirth());
		uiResponse.setSsn(provider.getSsn());
		uiResponse.setGender(provider.getGender());
		uiResponse.setEmail(provider.getEmail());
		uiResponse.setAddressLine1(provider.getAddressLine1());
		uiResponse.setAddressLine2(provider.getAddressLine2());
		uiResponse.setCity(provider.getCity());
		uiResponse.setState(provider.getState());
		uiResponse.setZipCode(provider.getZipCode());
		uiResponse.setPrimaryNumber(provider.getPrimaryNumber());
		uiResponse.setSecondaryNumber(provider.getSecondaryNumber());
		uiResponse.setPrimaryPracticeLocation(provider.getPrimaryPracticeLocation());
		uiResponse.setPagerCode(provider.getPagerCode());
		uiResponse.setTaxonomyCode(provider.getTaxonomyCode());
		uiResponse.setDeaNumber(provider.getDeaNumber());
		uiResponse.setDeaStartDate(provider.getDeaStartDate());
		uiResponse.setDeaEndDate(provider.getDeaEndDate());
		uiResponse.setNpi(provider.getNpi());
		uiResponse.setSpecialLicense(provider.getSpecialLicense());
		uiResponse.setSpecialLicenseStartDate(provider.getSpecialLicenseStartDate());
		uiResponse.setSpecialLicenseEndDate(provider.getSpecialLicenseEndDate());
		uiResponse.setLicensingState(provider.getLicensingState());
		uiResponse.setTaxId(provider.getTaxId());
		uiResponse.setTaxIdType(provider.getTaxIdType());
		uiResponse.setSendProviderCredentials(provider.isSendProviderCredentials());
		return uiResponse;


	}

	public static List<ProviderUiResponse> ConvertToListOfProviderUiResponse(List<ProviderEntity> providers) {
		List<ProviderUiResponse> listOfProviderUIResponse=new ArrayList<ProviderUiResponse>();

		for(ProviderEntity p:providers){
			ProviderUiResponse providerUiResponse=convertToProviderUiResponse(p);
			listOfProviderUIResponse.add(providerUiResponse);
		}
	return  listOfProviderUIResponse;
	}

	public static void checkConflictAddProvider(ProviderUIRequest providerUIRequest,
			ExternalServiceResponseModel externalNpiCallResponse) {
		
		Map<String ,String> hm = new HashMap<String,String>();
		externalNpiCallResponse.getResults().forEach(result->result.getTaxonomies().forEach(taxonomy->{hm.put(taxonomy.getCode(), taxonomy.getLicense());}));
		
		if(!hm.containsKey(providerUIRequest.getTaxonomyCode())){
			throw new RuntimeException("taxonomy code mismatch");
		}
		else 
		{
			if(!providerUIRequest.getSpecialLicense().equals(hm.get(providerUIRequest.getTaxonomyCode())))
			{
				throw new RuntimeException("Licence details Mismatch");
			}
			
		}
		
	}
}
