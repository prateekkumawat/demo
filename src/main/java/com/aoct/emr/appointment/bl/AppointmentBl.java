package com.aoct.emr.appointment.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.service.AppointmentService;
import com.aoct.emr.appointment.uiRequest.BookAppointmentUiRequest;
import com.aoct.emr.appointment.utility.AppointmentHelper;

@Component
public class AppointmentBl {
	
	@Autowired
	
	private AppointmentService service;

	public Long bookAppointment(BookAppointmentUiRequest uiRequest) {
		// TODO Auto-generated method stub
		AppointmentEntity appointment=AppointmentHelper.convertFromBookAppointmentUiRequest(uiRequest);
		return service.bookAppointment(appointment);
	}

}
