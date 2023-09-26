package com.aoct.emr.patient.service;

import com.aoct.emr.patient.entity.VaccineEntity;
import com.aoct.emr.patient.repository.VaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineService {
    @Autowired
    VaccineRepo repo;
    public Long addVaccine(VaccineEntity v) {
        VaccineEntity vaccine=repo.save(v);
        if(vaccine==null){
            return null;
        }
        else{
            return vaccine.getVaccinationId();
        }
    }

    public VaccineEntity getByVaccinationId(Long vaccineId) {
       return repo.getReferenceById(vaccineId);
    }

    public List<VaccineEntity> getVaccinesByPatientId(Long patientId) {
        return repo.getVaccinesByPatientId(patientId);
    }
}
