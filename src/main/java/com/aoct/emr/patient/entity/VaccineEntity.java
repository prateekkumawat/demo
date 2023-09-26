package com.aoct.emr.patient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class VaccineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String vaccineInfo;
    private String vaccineName;
    private String ndc;
    private  String cvx;
}
