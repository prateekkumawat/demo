package com.aoct.emr.patient.uiRequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PrescriptionUiRequest {

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
