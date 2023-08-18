package com.aoct.emr.appointment.utility;

import com.aoct.emr.appointment.UiResponse.AppointmentUiResponse;
import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.uiRequest.AppointmentUiRequest;

import java.util.ArrayList;
import java.util.List;

public class AppointmentHelper {

	public static AppointmentEntity convertFromBookAppointmentUiRequest(AppointmentUiRequest uiRequest) {
		// TODO Auto-generated method 
		AppointmentEntity appointment = new AppointmentEntity();
		appointment.setPatientId(uiRequest.getPatientId());
		appointment.setPatientName(uiRequest.getPatientName());
		appointment.setProviderId(uiRequest.getProviderId());
		appointment.setProviderName(uiRequest.getProviderName());
		appointment.setReasonOfVisit(uiRequest.getReasonOfVisit());
		appointment.setScheduleDate(uiRequest.getScheduleDate());
		appointment.setScheduleStartTime(uiRequest.getScheduleStartTime());
		appointment.setScheduleEndTime(uiRequest.getScheduleEndTime());
		appointment.setTypeOfVisit(uiRequest.getTypeOfVisit());
		appointment.setCurrentStatusOfVisit(uiRequest.getCurrentStatusOfVisit());
		appointment.setSpeciality(uiRequest.getSpeciality());
		return appointment;
	}
	public static AppointmentUiResponse convertToBookAppointmentUiResponse(AppointmentEntity appointment) {
		// TODO Auto-generated method
		AppointmentUiResponse response=new AppointmentUiResponse();
		response.setAppointmentId(appointment.getAppointmentId());
		response.setPatientId(appointment.getPatientId());
		response.setPatientName(appointment.getPatientName());
		response.setProviderId(appointment.getProviderId());
		response.setProviderName(appointment.getProviderName());
		response.setReasonOfVisit(appointment.getReasonOfVisit());
		response.setScheduleDate(appointment.getScheduleDate());
		response.setScheduleStartTime(appointment.getScheduleStartTime());
		response.setScheduleEndTime(appointment.getScheduleEndTime());
		response.setTypeOfVisit(appointment.getTypeOfVisit());
		response.setCurrentStatusOfVisit(appointment.getCurrentStatusOfVisit());
		response.setSpeciality(appointment.getSpeciality());
		return response;
	}

	public static List<AppointmentUiResponse> convertToListOfAppointmentUiResponse(List<AppointmentEntity> appointments) {
	List<AppointmentUiResponse> listOfAppointmentResponse=new ArrayList<AppointmentUiResponse>();
	for(AppointmentEntity appointment:appointments){
		AppointmentUiResponse response=convertToBookAppointmentUiResponse(appointment);
		listOfAppointmentResponse.add(response);
	}
	return listOfAppointmentResponse;
	}
}
