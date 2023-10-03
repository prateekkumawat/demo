package com.aoct.emr.patient.utility;

import com.aoct.emr.patient.entity.LabsAndProceduresEntity;
import com.aoct.emr.patient.uiRequest.LabsAndProceduresUiRequest;
import com.aoct.emr.patient.uiResponse.LabsAndProceduresUiResponse;

import java.util.ArrayList;
import java.util.List;

public class LabsAndProceduresHelper {
    public static LabsAndProceduresEntity convertLabsAndProceduresUiRequest(LabsAndProceduresUiRequest request) {
        LabsAndProceduresEntity l=new LabsAndProceduresEntity();
        l.setLabName(request.getLabName());
        l.setSentTo(request.getSentTo());
        l.setExpirationDate(request.getExpirationDate());
        l.setNoteForLab(request.getNoteForLab());
        l.setNoteForAdmin(request.getNoteForAdmin());
        l.setImaging(request.getImaging());
        l.setExpectedDate(request.getExpectedDate());
        l.setOrderStatus(request.getOrderStatus());
        l.setPriority(request.getPriority());
        l.setReasonForOrder(request.getReasonForOrder());
        l.setNoteForImaging(request.getNoteForImaging());
        l.setProcedures(request.getProcedures());
        l.setProcedureDate(request.getProcedureDate());
        l.setDxCode(request.getDxCode());
        l.setProceduresNote(request.getProceduresNote());
        l.setExternalFlag(request.isExternalFlag());
        l.setLabsFlag(request.getLabsFlag());
        l.setPatientId(request.getPatientId());
        return l;
    }
    public static LabsAndProceduresUiResponse convertLabsAndProceduresUiResponse(LabsAndProceduresEntity l){
        LabsAndProceduresUiResponse response=new LabsAndProceduresUiResponse();
        response.setLabsAndProceduresId(l.getLabsAndProceduresId());
        response.setLabName(l.getLabName());
        response.setSentTo(l.getSentTo());
        response.setExpirationDate(l.getExpirationDate());
        response.setNoteForLab(l.getNoteForLab());
        response.setNoteForAdmin(l.getNoteForAdmin());
        response.setImaging(l.getImaging());
        response.setExpectedDate(l.getExpectedDate());
        response.setOrderStatus(l.getOrderStatus());
        response.setPriority(l.getPriority());
        response.setReasonForOrder(l.getReasonForOrder());
        response.setNoteForImaging(l.getNoteForImaging());
        response.setProcedures(l.getProcedures());
        response.setProcedureDate(l.getProcedureDate());
        response.setDxCode(l.getDxCode());
        response.setProceduresNote(l.getProceduresNote());
        response.setExternalFlag(l.isExternalFlag());
        response.setLabsFlag(l.getLabsFlag());
        response.setPatientId(l.getPatientId());
        return response;
    }

    public  static List<LabsAndProceduresUiResponse> convertListOfLabsAndProceduresUiResponse(List<LabsAndProceduresEntity> labs){
        List<LabsAndProceduresUiResponse> responses=new ArrayList<>();
        for(LabsAndProceduresEntity l:labs){
            LabsAndProceduresUiResponse response=convertLabsAndProceduresUiResponse(l);
            responses.add(response);
        }
        return responses;
    }
}
