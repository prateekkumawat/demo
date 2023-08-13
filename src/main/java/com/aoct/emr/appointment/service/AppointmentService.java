package com.aoct.emr.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.repo.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository repo;

	public long  bookAppointment(AppointmentEntity e) {
		// TODO Auto-generated method stub
		AppointmentEntity appointment = repo.save(e);
		if(appointment==null)
		{
			return 0;
		}
		return appointment.getAppointmentId();	
		
		
	}

}
