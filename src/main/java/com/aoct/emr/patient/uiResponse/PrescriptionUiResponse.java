package com.aoct.emr.patient.uiResponse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PrescriptionUiResponse {
    private Long prescriptionId;

    private String drugId;
    private Long patientId;
    private String direction;
    private String quantity;
    private String when;
    private String dispense;
    private String frequency;
    private String duration;
    private LocalDate earliestFillDate;
    private String additionalRefills;
    private boolean activeFlag;
    private boolean prescribedFlag;
    private String drugName;
}
