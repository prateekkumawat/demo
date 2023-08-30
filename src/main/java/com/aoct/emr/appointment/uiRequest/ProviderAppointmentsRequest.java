package com.aoct.emr.appointment.uiRequest;

import lombok.Data;

@Data
public class ProviderAppointmentsRequest {
    private Long providerId;
    private int month;
    private int year;
}
