package com.aoct.emr.patient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Data
public class LabsAndProceduresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labsAndProceduresId;


    @NotNull
    private Long patientId;

    private String labName;
    private String sentTo;
    private String expirationDate;
    private String noteForLab;
    private String noteForAdmin;

    private String imaging;
    private LocalDate expectedDate;
    private String orderStatus;
    private String priority;
    private String reasonForOrder;
    private String noteForImaging;

    private String procedures;
    private LocalDate procedureDate;
    private String dxCode;
    private String proceduresNote;
    private boolean externalFlag; //if external flag is false In-house should be selected else external

    @NotNull
    private String labsFlag; //flag to select tab Labs, Imaging or Procedures;




}
