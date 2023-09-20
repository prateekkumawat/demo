package com.aoct.emr.patient.utility;

import com.aoct.emr.patient.entity.PrescriptionEntity;
import com.aoct.emr.patient.uiRequest.PrescriptionUiRequest;
import com.aoct.emr.patient.uiResponse.PrescriptionUiResponse;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionHelper {
    public static PrescriptionEntity convertPrescriptionUiRequest(PrescriptionUiRequest prescription) {
        PrescriptionEntity p=new PrescriptionEntity();
        p.setPatientId(prescription.getPatientId());
        p.setDrugId(prescription.getDrugId());
        p.setDirection(prescription.getDirection());
        p.setDispense(prescription.getDispense());
        p.setDuration(prescription.getDuration());
        p.setWhen(prescription.getWhen());
        p.setFrequency(prescription.getFrequency());
        p.setQuantity(prescription.getQuantity());
        p.setAdditionalRefills(prescription.getAdditionalRefills());
        p.setEarliestFillDate(prescription.getEarliestFillDate());

        return p;
    }

    public static PrescriptionUiResponse convertPrescriptionUiresponse(PrescriptionEntity p){
        PrescriptionUiResponse response=new PrescriptionUiResponse();
        response.setPrescriptionId(p.getPrescriptionId());
        response.setPatientId(p.getPatientId());
        response.setDrugId(p.getDrugId());
        response.setDirection(p.getDirection());
        response.setDispense(p.getDispense());
        response.setDuration(p.getDuration());
        response.setWhen(p.getWhen());
        response.setFrequency(p.getFrequency());
        response.setQuantity(p.getQuantity());
        response.setAdditionalRefills(p.getAdditionalRefills());
        p.setEarliestFillDate(p.getEarliestFillDate());
        return response;

    }

    public static List<PrescriptionUiResponse> convertListOfPrescriptionUiResponse(List<PrescriptionEntity> prescriptions) {
        List<PrescriptionUiResponse> listOfPrescription=new ArrayList<>();
        for(PrescriptionEntity p:prescriptions){
            PrescriptionUiResponse response=convertPrescriptionUiresponse(p);
            listOfPrescription.add(response);
        }
        return listOfPrescription;
    }
}
