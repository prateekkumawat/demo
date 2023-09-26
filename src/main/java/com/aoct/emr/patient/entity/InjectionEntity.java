package com.aoct.emr.patient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class InjectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
