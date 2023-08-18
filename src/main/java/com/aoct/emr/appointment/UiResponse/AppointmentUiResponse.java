package com.aoct.emr.appointment.UiResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Getter
@Setter
public class AppointmentUiResponse {
    private Long appointmentId;
    private Long patientId;
    private String patientName;
    private Long providerId;
    private String providerName;
    private String typeOfVisit;
    private String speciality;
    private String currentStatusOfVisit;
    private String reasonOfVisit;

    private LocalDate scheduleDate;
    private LocalTime scheduleStartTime;
    private LocalTime scheduleEndTime;
}
