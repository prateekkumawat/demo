package com.aoct.emr.patient.bl;


import com.aoct.emr.patient.entity.GuarantorEntity;
import com.aoct.emr.patient.service.GuarantorService;
import com.aoct.emr.patient.uiRequest.GuarantorUiRequest;
import com.aoct.emr.patient.uiResponse.GuarantorUiResponse;
import com.aoct.emr.patient.utility.GuarantorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GuarantorBl {

    @Autowired
    GuarantorService guarantorService;

    public Long createGuarantor(GuarantorUiRequest request){
        GuarantorEntity g= GuarantorHelper.convertFromGuarantorUiRequest(request);
        Long guarantorId=guarantorService.createGuarantor(g);
        return guarantorId;
    }
    public GuarantorUiResponse getGuarantor(Long guarantorId){
        GuarantorEntity g=guarantorService.getGuarantorById(guarantorId);
        GuarantorUiResponse guarantorUiResponse=GuarantorHelper.convertToGuarantorUiResponse(g);
        return guarantorUiResponse;

    }

    public List<GuarantorUiResponse> getAllGuarantor() {

        List<GuarantorEntity> guarantors= guarantorService.getAllGuarantor();
        List<GuarantorUiResponse> listOfGuarantors=GuarantorHelper.convertToGuarantorListUiResponse(guarantors);
        return listOfGuarantors;
    }
}


