package com.aoct.emr.patient.uiRequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class VaccineUiRequest {
    private Long patientId;
    private String orderedBy;
    private String administeredBy;
    private String administeredTime;
    private LocalDate administeredDate;
    private String facility;
    private String route;
    private String site;
    private String dose;
    private String units;
    private String vaccineNumber;
    private String totalVaccines;
    private String vfcClass;
    private String visProvided;
    private String funding;
    private boolean successFlag;
    private String vaccineInfo;
    private Long vaccinationId;
    private String vaccineName;
    private String ndc;
    private  String cvx;

}
