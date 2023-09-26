package com.aoct.emr.patient.utility;

import com.aoct.emr.patient.entity.InjectionEntity;
import com.aoct.emr.patient.uiRequest.InjectionUiRequest;
import com.aoct.emr.patient.uiResponse.InjectionUiResponse;

import java.util.ArrayList;
import java.util.List;

public class InjectionHelper {
    public static InjectionEntity convertInjectionUiRequest(InjectionUiRequest request) {
        InjectionEntity i=new InjectionEntity();
        i.setPatientId(request.getPatientId());
        i.setOrderedBy(request.getOrderedBy());
        i.setAdministeredBy(request.getAdministeredBy());
        i.setAdministeredOn(request.getAdministeredOn());
        i.setTime(request.getTime());
        i.setExpirationDate(request.getExpirationDate());
        i.setLocation(request.getLocation());
        i.setRoute(request.getRoute());
        i.setSite(request.getSite());
        i.setDose(request.getDose());
        i.setDoseUnits(request.getDoseUnits());
        i.setFrequency(request.getFrequency());
        i.setDuration(request.getDuration());
        i.setDurationUnits(request.getDurationUnits());
        i.setNotes(request.getNotes());
        return i;
    }
    public static InjectionUiResponse convertInjectionUiResponse(InjectionEntity i){
        InjectionUiResponse response=new InjectionUiResponse();
        response.setInjectionId(i.getInjectionId());
        response.setPatientId(i.getPatientId());
        response.setOrderedBy(i.getOrderedBy());
        response.setAdministeredBy(i.getAdministeredBy());
        response.setAdministeredOn(i.getAdministeredOn());
        response.setTime(i.getTime());
        response.setExpirationDate(i.getExpirationDate());
        response.setLocation(i.getLocation());
        response.setRoute(i.getRoute());
        response.setSite(i.getSite());
        response.setDose(i.getDose());
        response.setDoseUnits(i.getDoseUnits());
        response.setFrequency(i.getFrequency());
        response.setDuration(i.getDuration());
        response.setDurationUnits(i.getDurationUnits());
        response.setNotes(i.getNotes());
        return response;

    }
    public static List<InjectionUiResponse> convertInjectionListUiResponse(List<InjectionEntity> injections){
        List<InjectionUiResponse> injectionList=new ArrayList<>();
        for(InjectionEntity i:injections){
            InjectionUiResponse response=convertInjectionUiResponse(i);
            injectionList.add(response);
        }
        return injectionList;
    }
}
