package com.aoct.emr.provider.controller;

import com.aoct.emr.patient.uiRequest.PatientUiRequest;
import com.aoct.emr.provider.bl.ProviderBl;
import com.aoct.emr.provider.entity.ProviderEntity;
import com.aoct.emr.provider.uiRequest.ProviderUIRequest;

import com.aoct.emr.provider.uiResponse.ProviderUiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {
   @Autowired
   ProviderBl bl;
   
   @PostMapping("/createProvider")
   public String addProviderDetails(@RequestBody ProviderUIRequest providerUIRequest) {

		return bl.createProvider(providerUIRequest);

	}

    @GetMapping("/getReferringProviderDetails/{npiNumber}")
    public String getReferringProviderDetails(@PathVariable String npiNumber)
    {
        return bl.searchProvider(npiNumber);
    }
    @GetMapping("/getProviderDetail/{providerId}")
    public ProviderUiResponse getProviderDetail(String providerId){
        return bl.getProviderDetail(providerId);
    }

    @GetMapping("/getAllProviderDetails")
    public List<ProviderUiResponse> getProviderDetails(){
       return bl.getAllProviderDetails();
    }


}

