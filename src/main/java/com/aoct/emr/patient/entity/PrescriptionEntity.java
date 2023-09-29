package com.aoct.emr.patient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PrescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    private String drugId;
    private Long patientId;
    private String direction;
    private String quantity;
    private String whenString;
    private String dispense;
    private String frequency;
    private String duration;
    private LocalDate earliestFillDate;
    private String additionalRefills;
    private boolean activeFlag;
    private boolean prescribedFlag;
    private String drugName;
    private boolean supplementsFlag;
}
