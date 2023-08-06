package com.aoct.emr.provider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ReferringProvider {
	
    @Id
	private String npi;
    private String npiType;
    private String specialty;
    private String providerFirstName;
    private String providerLastName;
    private String organisationName;

}
