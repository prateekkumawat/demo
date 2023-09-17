package com.aoct.emr.patient.utility;



import com.aoct.emr.patient.entity.AttorneyEntity;
import com.aoct.emr.patient.uiRequest.AttorneyUiRequest;
import com.aoct.emr.patient.uiResponse.AttorneyUiResponse;

import java.util.ArrayList;
import java.util.List;

public class AttorneyHelper {
    public static AttorneyEntity convertFromAttorneyUiRequest(AttorneyUiRequest request){
        AttorneyEntity a=new AttorneyEntity();
        a.setCity(request.getCity());
        a.setPhone(request.getPhone());
        a.setCountry(request.getCountry());
        a.setFirstName(request.getFirstName());
        a.setLastName(request.getLastName());
        a.setState(request.getState());
        a.setOfficeAdd(request.getOfficeAdd());
        a.setNotes(request.getNotes());
        a.setZipCode(request.getZipCode());
        return a;

    }
    public  static AttorneyUiResponse convertToAttorneyUiResponse(AttorneyEntity a){
        AttorneyUiResponse attorneyUiResponse=new AttorneyUiResponse();
        attorneyUiResponse.setState(a.getState());
        attorneyUiResponse.setCountry(a.getCountry());
        attorneyUiResponse.setCountry(a.getCity());
        attorneyUiResponse.setOfficeAdd(a.getOfficeAdd());
        attorneyUiResponse.setZipCode(a.getZipCode());
        attorneyUiResponse.setNotes(a.getNotes());
        attorneyUiResponse.setFirstName(a.getFirstName());
        attorneyUiResponse.setLastName(a.getLastName());
        attorneyUiResponse.setPhone(a.getPhone());

        return attorneyUiResponse;
    }
    public static List<AttorneyUiResponse> convertToAttorneyListUiResponse(List<AttorneyEntity> attorneys){
        List<AttorneyUiResponse> attorneyUiResponseList=new ArrayList<AttorneyUiResponse>();

        for(AttorneyEntity a:attorneys){
            AttorneyUiResponse attorneyUiResponse=convertToAttorneyUiResponse(a);
            attorneyUiResponseList.add(attorneyUiResponse);
        }
        return attorneyUiResponseList;
    }
}
