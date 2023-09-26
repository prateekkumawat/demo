package com.aoct.emr.patient.uiResponse;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InjectionUiResponse {
    private Long injectionId;
    private Long patientId;
    private String orderedBy;
    private String administeredBy;
    private String time;
    private LocalDate administeredOn;
    private LocalDate expirationDate;
    private String location;
    private String route;
    private String site;
    private String dose;
    private String doseUnits;
    private String frequency;
    private String duration;
    private String durationUnits;
    private String notes;
}
