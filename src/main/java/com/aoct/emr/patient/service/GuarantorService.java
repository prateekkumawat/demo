package com.aoct.emr.patient.service;


import com.aoct.emr.patient.entity.GuarantorEntity;
import com.aoct.emr.patient.repository.GuarantorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuarantorService {

    @Autowired
    GuarantorRepository guarantorRepo;

    public Long createGuarantor(GuarantorEntity guarantor){
        GuarantorEntity g=guarantorRepo.save(guarantor);
        if(g!=null){
            return g.getGuarantorId();
        }
        return null;
    }
    public GuarantorEntity getGuarantorById(Long guarantorId){
        GuarantorEntity g=guarantorRepo.getById(guarantorId);
        return g;
    }

    public List<GuarantorEntity> getAllGuarantor(){
        return guarantorRepo.findAll();
    }



}
