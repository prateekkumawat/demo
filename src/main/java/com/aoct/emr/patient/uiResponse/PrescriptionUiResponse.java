package com.aoct.emr.patient.uiResponse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PrescriptionUiResponse {
    private Long prescriptionId;

    private Long drugId;
    private Long patientId;
    private String direction;
    private String quantity;
    private String when;
    private String dispense;
    private String frequency;
    private String duration;
    private LocalDate earliestFillDate;
    private String additionalRefills;
}
