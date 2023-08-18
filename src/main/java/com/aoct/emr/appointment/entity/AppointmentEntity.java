package com.aoct.emr.appointment.entity	;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class AppointmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;

	private LocalDate scheduleDate;
	private LocalTime scheduleStartTime;
	private LocalTime scheduleEndTime;

	private Long patientId;
	private String patientName;
	private Long providerId;
	private String providerName;
	private String typeOfVisit;
	private String speciality;
	private String currentStatusOfVisit;
	private String reasonOfVisit;

}
