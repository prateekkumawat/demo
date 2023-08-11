package com.aoct.emr.provider.uiRequest;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProviderUIRequest {
	
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
