package com.aoct.emr.provider.utility;

import com.aoct.emr.provider.entity.ProviderEntity;
import com.aoct.emr.provider.uiRequest.ProviderUIRequest;
import com.aoct.emr.provider.uiResponse.ProviderUiResponse;

import java.util.List;

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

		return null;
	}

	public static List<ProviderUiResponse> ConvertToListOfProviderUiResponse(List<ProviderEntity> providers) {
	return  null;
	}
}
