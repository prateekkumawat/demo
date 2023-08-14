package com.aoct.emr.appointment.bl;

import com.aoct.emr.appointment.UiResponse.AppointmentUiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.service.AppointmentService;
import com.aoct.emr.appointment.uiRequest.AppointmentUiRequest;
import com.aoct.emr.appointment.utility.AppointmentHelper;

import java.time.LocalDate;
import java.util.List;

@Component
public class AppointmentBl {
	
	@Autowired
	
	private AppointmentService service;

	public Long bookAppointment(AppointmentUiRequest uiRequest) {
		// TODO Auto-generated method stub
		AppointmentEntity appointment=AppointmentHelper.convertFromBookAppointmentUiRequest(uiRequest);
		return service.bookAppointment(appointment);
	}

    public List<AppointmentUiResponse> getProviderSchedule(Long providerId, LocalDate date) {
		List<AppointmentEntity> appointments= service.getProviderSchedule(date,providerId);

		List<AppointmentUiResponse> response=AppointmentHelper.convertToListOfAppointmentUiResponse(appointments);
		return response;
    }

	public AppointmentUiResponse getAppointmentDetail(Long appointmentId) {
		AppointmentEntity appointment=service.getAppointmentDetail(appointmentId);
		AppointmentUiResponse response=AppointmentHelper.convertToBookAppointmentUiResponse(appointment);
		return response;
	}
}
