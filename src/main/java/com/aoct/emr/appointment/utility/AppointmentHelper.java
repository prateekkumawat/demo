package com.aoct.emr.appointment.utility;

import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.uiRequest.BookAppointmentUiRequest;

public class AppointmentHelper {

	public static AppointmentEntity convertFromBookAppointmentUiRequest(BookAppointmentUiRequest uiRequest) {
		// TODO Auto-generated method 
		AppointmentEntity appointment = new AppointmentEntity();
		appointment.setPatientId(uiRequest.getPatientId());
		appointment.setProviderId(uiRequest.getProviderId());
		appointment.setReasonOfVisit(uiRequest.getReasonOfVisit());
		appointment.setScheduleDate(uiRequest.getScheduleDate());
		appointment.setScheduleStartTime(uiRequest.getScheduleStartTime());
		appointment.setScheduleEndTime(uiRequest.getScheduleEndTime());
		appointment.setTypeOfVisit(uiRequest.getTypeOfVisit());
		appointment.setCurrentStatusOfVisit(uiRequest.getCurrentStatusOfVisit());
		appointment.setSpeciality(uiRequest.getSpeciality());
		return appointment;
	}

}
