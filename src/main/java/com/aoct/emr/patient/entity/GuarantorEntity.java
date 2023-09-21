package com.aoct.emr.patient.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class GuarantorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guarantorId")
    private Long guarantorId;
    private String lastName;
    private String firstName;
    private String type;
    private String phone;
    private String gender;
    private LocalDate dateOfBirth;
    private String guarantorRecordNumber;
}
