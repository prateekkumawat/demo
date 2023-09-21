package com.aoct.emr.patient.service;


import com.aoct.emr.patient.entity.AttorneyEntity;
import com.aoct.emr.patient.repository.AttorneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttorneyService {
   @Autowired
   AttorneyRepository attorneyRepository;

   public Long createAttorney(AttorneyEntity attorney){
       AttorneyEntity a=attorneyRepository.save(attorney);
       if(a!=null){
           return a.getAttorneyId();
       }
       return null;
   }
   public AttorneyEntity getAttorney(Long attorneyId){
       AttorneyEntity a=attorneyRepository.getById(attorneyId);
       return a;
   }
   public List<AttorneyEntity> getAllAttorney(){
       return attorneyRepository.findAll();
   }
}
