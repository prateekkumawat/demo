package com.aoct.emr.patient.uiResponse;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GuarantorUiResponse {
    private String guarantorRecordNumber;
    private String lastName;
    private String firstName;
    private String type;
    private String phone;
    private String gender;
    private LocalDate dateOfBirth;
}
