package com.aoct.emr.patient.service;

import com.aoct.emr.patient.entity.InjectionEntity;
import com.aoct.emr.patient.repository.InjectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjectionService {
    @Autowired
    InjectionRepo repo;
    public Long addInjection(InjectionEntity i) {
        InjectionEntity injection=repo.save(i);
        if(injection==null){
            return null;
        }
        else{
            return injection.getInjectionId();
        }
    }

    public List<InjectionEntity> getInjectionsByPatientId(Long patientId) {
        return repo.getInjectionsByPatientId(patientId);
    }
}
