package com.aoct.emr.appointment.bl;

import com.aoct.emr.appointment.UiResponse.AppointmentUiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.service.AppointmentService;
import com.aoct.emr.appointment.uiRequest.AppointmentUiRequest;
import com.aoct.emr.appointment.utility.AppointmentHelper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AppointmentBl {
	
	@Autowired
	
	private AppointmentService service;

	public Long bookAppointment(AppointmentUiRequest uiRequest) {

		AppointmentEntity appointment=AppointmentHelper.convertFromBookAppointmentUiRequest(uiRequest);
		return service.bookAppointment(appointment);
	}

    public List<AppointmentUiResponse> getProviderSchedule(Long providerId, LocalDate date) {
		List<AppointmentEntity> appointments= service.getProviderSchedule(date,providerId);

		return AppointmentHelper.convertToListOfAppointmentUiResponse(appointments);
    }

	public AppointmentUiResponse getAppointmentDetail(Long appointmentId) {
		AppointmentEntity appointment=service.getAppointmentDetail(appointmentId);
		AppointmentUiResponse response=AppointmentHelper.convertToBookAppointmentUiResponse(appointment);
		return response;
	}

	public List<AppointmentUiResponse> getProviderSchedule(LocalDate date) {
		List<AppointmentEntity> appointments= service.getProviderSchedule(date);
		List<AppointmentEntity> sortedAppointmentList = appointments.stream()
				.sorted(Comparator.comparing(AppointmentEntity::getScheduleStartTime))
				.collect(Collectors.toList());

		List<AppointmentUiResponse> response=AppointmentHelper.convertToListOfAppointmentUiResponse(sortedAppointmentList);
		return response;
	}

	public List<LocalDate> getAppointmentsByMonth(int month, int year) {
		List<LocalDate> availableAppointmentDates=service.getAppointmentsByMonth(month,year);
		return 	availableAppointmentDates;
	}
	public List<AppointmentUiResponse> getAppointmentByPatientId(Long patientId){
		List<AppointmentEntity> appointments=service.getAppointmentByPatientId(patientId);
		List<AppointmentUiResponse> responses=AppointmentHelper.convertToListOfAppointmentUiResponse(appointments);
		return responses;
	}
}
