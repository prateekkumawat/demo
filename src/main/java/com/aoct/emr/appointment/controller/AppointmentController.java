package com.aoct.emr.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoct.emr.appointment.bl.AppointmentBl;
import com.aoct.emr.appointment.uiRequest.BookAppointmentUiRequest;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentBl bl;
	
	@PostMapping("/bookAppointment")
	public Long bookAppointment(@RequestBody BookAppointmentUiRequest uiRequest)
	{
		return bl.bookAppointment(uiRequest);
	}

}
