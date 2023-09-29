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
        p.setWhenString(prescription.getWhen());
        p.setFrequency(prescription.getFrequency());
        p.setQuantity(prescription.getQuantity());
        p.setAdditionalRefills(prescription.getAdditionalRefills());
        p.setEarliestFillDate(prescription.getEarliestFillDate());
        p.setDrugName(prescription.getDrugName());
        p.setActiveFlag(prescription.isActiveFlag());
        p.setPrescribedFlag(prescription.isPrescribedFlag());
        p.setSupplementsFlag(prescription.isSupplementsFlag());

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
        response.setWhen(p.getWhenString());
        response.setFrequency(p.getFrequency());
        response.setQuantity(p.getQuantity());
        response.setAdditionalRefills(p.getAdditionalRefills());
        response.setEarliestFillDate(p.getEarliestFillDate());
        response.setDrugName(p.getDrugName());
        response.setActiveFlag(p.isActiveFlag());
        response.setPrescribedFlag(p.isPrescribedFlag());
        response.setSupplementsFlag(p.isSupplementsFlag());

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
