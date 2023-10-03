package com.aoct.emr.patient.service;

import com.aoct.emr.patient.entity.LabsAndProceduresEntity;
import com.aoct.emr.patient.entity.VaccineEntity;
import com.aoct.emr.patient.repository.LabsAndProceduresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabsAndProceduresService {
    @Autowired
    LabsAndProceduresRepo repo;
    public Long addLabsAndProcedures(LabsAndProceduresEntity labsAndProcedures) {
        LabsAndProceduresEntity l=repo.save(labsAndProcedures);
        if(l==null){
            return null;
        }
        else{
            return l.getLabsAndProceduresId();
        }
    }

    public List<LabsAndProceduresEntity> getLabsAndProceduresByPatientId(Long patientId) {
        return repo.getLabsAndProceduresByPatientId(patientId);
    }
}
