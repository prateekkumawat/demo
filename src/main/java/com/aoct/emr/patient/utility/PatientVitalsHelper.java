package com.aoct.emr.patient.utility;

import com.aoct.emr.patient.entity.PatientVitals;
import com.aoct.emr.patient.uiRequest.PatientVitalsUiRequest;
import com.aoct.emr.patient.uiResponse.PatientVitalsUiResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientVitalsHelper {
    public static PatientVitals convertPatientVitalsUiRequest(PatientVitalsUiRequest request){
        PatientVitals v =new PatientVitals();
        v.setPatientId(request.getPatientId());
        v.setBmi(request.getBmi());
        v.setHeight(request.getHeight());
        v.setWeight(request.getWeight());
        v.setBloodPressure(request.getBloodPressure());
        v.setAssessmentDate(request.getAssessmentDate());
        v.setTemperature(request.getTemperature());
        v.setO2Saturation(request.getO2Saturation());
        v.setRespirationRate(request.getRespirationRate());
        v.setPulseRate(request.getPulseRate());
        return v;
    }

    public static PatientVitalsUiResponse convertPatientVitalsUiResponse(PatientVitals v){
        PatientVitalsUiResponse response=new PatientVitalsUiResponse();


        response.setBmi(v.getBmi());
        response.setHeight(v.getHeight());
        response.setWeight(v.getWeight());
        response.setBloodPressure(v.getBloodPressure());
        response.setTemperature(v.getTemperature());
        response.setPulseRate(v.getPulseRate());
        response.setO2Saturation(v.getO2Saturation());
        response.setRespirationRate(v.getRespirationRate());
        return response;
    }

    public static Map<LocalDate,PatientVitalsUiResponse> convertPatientVitalsListUiResponse(List<PatientVitals> vitalslist) {

        List<PatientVitalsUiResponse> listOfVitals=new ArrayList<>();
        Map<LocalDate,PatientVitalsUiResponse> map=new HashMap<>();
        for(PatientVitals v:vitalslist){
            map.put(v.getAssessmentDate(),convertPatientVitalsUiResponse(v));

        }
        return map;
    }
}
