package com.aoct.emr.appointment.controller;

import com.aoct.emr.appointment.UiResponse.AppointmentUiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aoct.emr.appointment.bl.AppointmentBl;
import com.aoct.emr.appointment.uiRequest.AppointmentUiRequest;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentBl bl;
	
	@PostMapping("/bookAppointment")
	public Long bookAppointment(@RequestBody AppointmentUiRequest uiRequest)
	{
		return bl.bookAppointment(uiRequest);
	}

	//getProviderSchedule
	@GetMapping("/getProviderSchedule/{providerId}/{date}")
	public List<AppointmentUiResponse> getProviderSchedule(@PathVariable  Long providerId, @PathVariable LocalDate date){
		return bl.getProviderSchedule(providerId,date);
	}
	//getAppointmentDetails appId return app

	@GetMapping("/getAppointmentDetail/{appointmentId}")
	public AppointmentUiResponse getAppointmentDetail(@PathVariable Long appointmentId){
		return bl.getAppointmentDetail(appointmentId);
	}

}
