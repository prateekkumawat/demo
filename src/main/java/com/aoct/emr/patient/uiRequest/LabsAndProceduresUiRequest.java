package com.aoct.emr.patient.uiRequest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LabsAndProceduresUiRequest {
    private String labName;
    private String sentTo;
    private String expirationDate;
    private String noteForLab;
    private String noteForAdmin;
    private Long patientId;
    private String imaging;
    private LocalDate expectedDate;
    private String orderStatus;
    private String priority;
    private String reasonForOrder;
    private String noteForImaging;

    private String procedures;
    private LocalDate procedureDate;
    private String dxCode;
    private String proceduresNote;
    private boolean externalFlag;
    private String labsFlag;
}
