package com.aoct.emr.patient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class AttorneyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AttorneyId;
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
