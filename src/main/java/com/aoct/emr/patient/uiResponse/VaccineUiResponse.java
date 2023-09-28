package com.aoct.emr.patient.uiResponse;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class VaccineUiResponse {
    private Long vaccinationId;
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
    private String vaccineName;
    private String ndc;
    private  String cvx;
    private Map<Integer, List<String>> vaccineInfo;
    private String vaccineInfoFlag;
    private String source;
    private String refusalReason;
    private String refusalNote;

}
