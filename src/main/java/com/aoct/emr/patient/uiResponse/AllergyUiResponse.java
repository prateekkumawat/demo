package com.aoct.emr.patient.uiResponse;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AllergyUiResponse {
    private Long allergyId;
    private Long patientId;
    private String reaction;
    private String severity;
    private LocalDate onset;
    private boolean activeAllergy;
}
