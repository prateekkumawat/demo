package com.aoct.emr.appointment.uiRequest;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AppointmentUiRequest {

	private Long appointmentId;
	private Long patientId;
	private Long providerId;
	private String typeOfVisit;
	private String speciality;
	private String currentStatusOfVisit;
	private String reasonOfVisit;

	private LocalDate scheduleDate;
	private LocalTime scheduleStartTime;
	private LocalTime scheduleEndTime;

}
