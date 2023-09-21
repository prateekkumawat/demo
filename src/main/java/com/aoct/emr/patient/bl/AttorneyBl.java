package com.aoct.emr.patient.bl;

import com.aoct.emr.patient.entity.AttorneyEntity;
import com.aoct.emr.patient.service.AttorneyService;
import com.aoct.emr.patient.uiRequest.AttorneyUiRequest;
import com.aoct.emr.patient.uiResponse.AttorneyUiResponse;
import com.aoct.emr.patient.utility.AttorneyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AttorneyBl {
    @Autowired
    AttorneyService attorneyService;
    public Long createAttorney(AttorneyUiRequest attorneyUiRequest) {
        AttorneyEntity a= AttorneyHelper.convertFromAttorneyUiRequest(attorneyUiRequest);
        Long attorneyId=attorneyService.createAttorney(a);
        return attorneyId;
    }
    public AttorneyUiResponse getAttorney(Long attorneyId){
        AttorneyEntity a=attorneyService.getAttorney(attorneyId);
        AttorneyUiResponse attorneyUiResponse= AttorneyHelper.convertToAttorneyUiResponse(a);
        return attorneyUiResponse;

    }
    public List<AttorneyUiResponse> getAllAttorney() {

        List<AttorneyEntity> attorneys= attorneyService.getAllAttorney();
        List<AttorneyUiResponse> listOfAttorneys=AttorneyHelper.convertToAttorneyListUiResponse(attorneys);
        return listOfAttorneys;
    }
}
