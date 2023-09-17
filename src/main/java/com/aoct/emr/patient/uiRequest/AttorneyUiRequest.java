package com.aoct.emr.patient.uiRequest;

import lombok.Data;

@Data
public class AttorneyUiRequest {
    private Long attorneyId;
    private String firstName;
    private String lastName;
    private String phone;
    private String officeAdd;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String notes;
}
