package com.aoct.emr.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aoct.emr.provider.externalResponseModel.ExternalServiceResponseModel;

@Service
public class ExternalService {
	
	@Autowired
	RestTemplate restTemplate;

	public ExternalServiceResponseModel callExternalNpiAPi(String npi) {
			String url = "https://npiregistry.cms.hhs.gov/api/?number=" + npi
					+ "&enumeration_type=&taxonomy_description=&name_purpose=&first_name=&use_first_name_alias=&last_name=&organization_name=&address_purpose=&city=&state=&postal_code=&country_code=&limit=&skip=&pretty=&version=2.1";
			ExternalServiceResponseModel response = restTemplate.getForObject(url, ExternalServiceResponseModel.class);
			
			return response;
		}

}
