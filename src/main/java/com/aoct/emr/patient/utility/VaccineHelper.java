package com.aoct.emr.patient.utility;

import com.aoct.emr.patient.entity.VaccineEntity;
import com.aoct.emr.patient.uiRequest.VaccineUiRequest;
import com.aoct.emr.patient.uiResponse.VaccineUiResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VaccineHelper {
    public static VaccineEntity convertVaccineUiRequest(VaccineUiRequest request) {
        VaccineEntity v=new VaccineEntity();
        v.setPatientId(request.getPatientId());
        v.setOrderedBy(request.getOrderedBy());
        v.setAdministeredBy(request.getAdministeredBy());
        v.setAdministeredDate(request.getAdministeredDate());
        v.setAdministeredTime(request.getAdministeredTime());
        v.setFacility(request.getFacility());
        v.setRoute(request.getRoute());
        v.setSite(request.getSite());
        v.setDose(request.getDose());
        v.setUnits(request.getUnits());
        v.setVaccineNumber(request.getVaccineNumber());
        v.setSuccessFlag(request.isSuccessFlag());
        v.setTotalVaccines(request.getTotalVaccines());
        v.setVfcClass(request.getVfcClass());
        v.setVisProvided(request.getVisProvided());
        v.setFunding(request.getFunding());
        v.setVaccineName(request.getVaccineName());
        v.setNdc(request.getNdc());
        v.setCvx(request.getCvx());
        return v;

    }

    public static VaccineUiResponse convertVaccineUiResponse(VaccineEntity v){
        VaccineUiResponse response=new VaccineUiResponse();
        response.setVaccinationId(v.getVaccinationId());
        response.setPatientId(v.getPatientId());
        response.setOrderedBy(v.getOrderedBy());
        response.setAdministeredBy(v.getAdministeredBy());
        response.setAdministeredDate(v.getAdministeredDate());
        response.setAdministeredTime(v.getAdministeredTime());
        response.setFacility(v.getFacility());
        response.setRoute(v.getRoute());
        response.setSite(v.getSite());
        response.setDose(v.getDose());
        response.setUnits(v.getUnits());
        response.setSuccessFlag(v.isSuccessFlag());
        response.setTotalVaccines(v.getTotalVaccines());
        response.setVfcClass(v.getVfcClass());
        response.setVisProvided(v.getVisProvided());
        response.setFunding(v.getFunding());
        response.setVaccineName(v.getVaccineName());
        response.setCvx(v.getCvx());
        response.setNdc(v.getNdc());


        String[] vaccineInfoParts=v.getVaccineInfo().split("\\|");

        Map<Integer,List<String>> vMap=new HashMap<>();

        for(String vaccineInfoPart:vaccineInfoParts){
            String[] keyValue=vaccineInfoPart.split(":");

            if(keyValue.length==2){
                int key=Integer.parseInt(keyValue[0]);
                String value=keyValue[1];

                vMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            }
        }
     response.setVaccineInfo(vMap);
        return response;
    }

    public static List<VaccineUiResponse> convertVaccineListUiResponse(List<VaccineEntity> vaccineEntities){
        List<VaccineUiResponse> vaccines=new ArrayList<>();
        for(VaccineEntity v:vaccineEntities){
            VaccineUiResponse vaccineUiResponse=convertVaccineUiResponse(v);
            vaccines.add(vaccineUiResponse);
        }
        return vaccines;
    }
}
