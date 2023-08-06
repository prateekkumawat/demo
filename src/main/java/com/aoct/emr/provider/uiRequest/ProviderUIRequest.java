package com.aoct.emr.provider.uiRequest;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProviderUIRequest {
	
	private String providerId;
	private String firstName;
	private String lastName;
	private String prefix;
	private String degree;
	private LocalDate dateOfBirth;
	private int ssn;
	private String gender;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int zipCode;
	private int primaryNumber;
	private int secondaryNumber;
	private String primaryPracticeLocation;
	private int pagerCode;
	private String taxonomyCode; 
	private String deaNumber;//out of scope
	private LocalDate deaStartDate;
	private LocalDate deaEndDate;
	private int npi;
	private String specialLicense;
	private LocalDate specialLicenseStartDate;
	private LocalDate specialLicenseEndDate;
	private String licensingState;
	private String taxIdType;
	private String taxId;
	private boolean sendProviderCredentials;

}
