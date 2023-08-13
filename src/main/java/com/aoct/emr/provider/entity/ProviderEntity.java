package com.aoct.emr.provider.entity;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "provider")
public class ProviderEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "providerId")
	private Long providerId;
	private String firstName;
	private String lastName;
	private String prefix;
	private String degree;
	private LocalDate dateOfBirth;
	private String ssn;
	private String gender;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String primaryNumber;
	private String secondaryNumber;
	private String primaryPracticeLocation;
	private String pagerCode;
	private String taxonomyCode; 
	private String deaNumber;//out of scope
	private LocalDate deaStartDate;
	private LocalDate deaEndDate;
	private String npi;
	private String specialLicense;
	private LocalDate specialLicenseStartDate;
	private LocalDate specialLicenseEndDate;
	private String licensingState;
	private String taxIdType;
	private String taxId;
	private boolean sendProviderCredentials;
	private String providerStatus;
	private String statusDescription;
	private String speciality;

}
