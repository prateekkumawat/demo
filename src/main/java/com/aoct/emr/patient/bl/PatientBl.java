package com.aoct.emr.patient.bl;

import com.aoct.emr.appointment.UiResponse.AppointmentUiResponse;
import com.aoct.emr.appointment.bl.AppointmentBl;
import com.aoct.emr.appointment.entity.AppointmentEntity;
import com.aoct.emr.appointment.service.AppointmentService;
import com.aoct.emr.appointment.utility.AppointmentHelper;
import com.aoct.emr.patient.entity.*;
import com.aoct.emr.patient.repository.VaccineTableRepo;
import com.aoct.emr.patient.service.*;
import com.aoct.emr.patient.uiRequest.*;
import com.aoct.emr.patient.uiResponse.*;
import com.aoct.emr.patient.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PatientBl {


    @Autowired
    PatientService service;

    @Autowired
    AppointmentBl appointmentBl;

    @Autowired
    AllergyService allergyService;

    @Autowired
    PatientVitalsService patientVitalsService;

    @Autowired
    PrescriptionService prescriptionService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    VaccineService vaccineService;

    @Autowired
    InjectionService injectionService;

    @Autowired
    VaccineTableRepo vaccineTableRepo;




//    @Autowired
//    ReadJsonFileService jsonService;
//    @Autowired
//    ExternalService externalService;



    // @Autowired

    //ReferringProviderService referringService;

    public Long createPatient(PatientUiRequest req)

    {

        PatientEntity p = PatientHelper.convertPatientRequest(req);

//

        Long patId=service.createPatient(p);

        return patId;

        //return null;

    }
    public PatientUiResponse getPatientDetails(Long patientId) {

        PatientEntity p=service.getPatientDetails(patientId);



        PatientUiResponse response=PatientHelper.convertToPatientUiResponse(p);

       List<AppointmentUiResponse> appointmentUiResponseLIst= appointmentBl.getAppointmentByPatientId(patientId);
       response.setAppointments(appointmentUiResponseLIst);

        //  ReferringProvider referringProvider = referringService.getReferringProviderById(p.getNpiId());

        // ReferringProviderUiResponse referringProviderUiResponse=PatientHelper.convertToReferringProviderUiResponse(referringProvider);



        //response.setReferringProvider(referringProviderUiResponse);

        // response.setReferringProvider(new com.mynx.mica.patient.uiResponse.ReferringProviderUiResponse());


        return response;

    }



    public List<PatientUiResponse> getAllPatients() {

        // TODO Auto-generated method stub

        List<PatientEntity> patients =service.getAllPatients();

        List<PatientUiResponse> listOfPatients=PatientHelper.convertToPatientListUiResponse(patients);

        return listOfPatients;

    }

    public void savePatientPicture(){



    }

    public Long addAllergy(AllergyUiRequest allergyUiRequest) {
        Allergy a= AllergyHelper.convertAllergyUiRequest(allergyUiRequest);

        Long patientAllergyId=allergyService.addAllergy(a);
        return patientAllergyId;
    }

    public List<AllergyUiResponse> getPatientAllergy(Long patientId) {
        List<Allergy> allergyList=allergyService.getPatientAllergy(patientId);
        List<AllergyUiResponse> responses=AllergyHelper.convertAllergyListUiResponse(allergyList);
        return responses;
    }

    public Long addVitalsForPatient(PatientVitalsUiRequest patientVitalsUiRequest) {

        // String bmi=PatientVitalsHelper.bmiCalculator(patientVitalsUiRequest.getHeight(),patientVitalsUiRequest.getWeight());
        // patientVitalsUiRequest.setBmi(bmi);

        PatientVitals v= PatientVitalsHelper.convertPatientVitalsUiRequest(patientVitalsUiRequest);

        Long vitalsId=patientVitalsService.addVitalsForPatient(v);
        return vitalsId;
    }

    public Map<LocalDate,PatientVitalsUiResponse> getVitalsForPatient(Long patientId) {
        List<PatientVitals> vitalslist=patientVitalsService.getVitalsForPatient(patientId);
        Map<LocalDate,PatientVitalsUiResponse> responses=PatientVitalsHelper.convertPatientVitalsListUiResponse(vitalslist);

         List<Map.Entry<LocalDate, PatientVitalsUiResponse>> entryList = new ArrayList<>(responses.entrySet());

        Collections.sort(entryList, (entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey()));

        Map<LocalDate, PatientVitalsUiResponse> sortedMap = entryList.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        return sortedMap;

    }

    public Map<Integer, String> getAllAllergy() {
        Map<Integer,String> hm=new HashMap<>();
        hm.put(1,"Penicillin");
        hm.put(2,"Pollen");
        hm.put(3,"Sand");
        hm.put(4,"FS Shampoo");
        return hm;


    }

    public Long addPrescription(PrescriptionUiRequest prescription) {
        PrescriptionEntity p= PrescriptionHelper.convertPrescriptionUiRequest(prescription);
        Long prescriptionId= prescriptionService.addPrescription(p);
        return prescriptionId;
    }

    public List<PrescriptionUiResponse> getPrescriptionByPatientId(Long patientId) {
        List<PrescriptionEntity> prescriptions=prescriptionService.getPrescriptionByPatientId(patientId);
        List<PrescriptionUiResponse> listOfPrescription=PrescriptionHelper.convertListOfPrescriptionUiResponse(prescriptions);
        return listOfPrescription;
    }

    public PrescriptionUiResponse getPrescriptionById(Long prescriptionId) {
        PrescriptionEntity p=prescriptionService.getPrescriptionById(prescriptionId);
        PrescriptionUiResponse response=PrescriptionHelper.convertPrescriptionUiresponse(p);
        return response;

    }

    public List<AppointmentUiResponse> getAppointmentByPatientId(Long patientId) {
        List<AppointmentEntity> appointments = appointmentService.getAppointmentByPatientId(patientId);
        List<AppointmentUiResponse> responses = appointments.stream()
                .map(AppointmentHelper::convertToBookAppointmentUiResponse)
                .collect(Collectors.toList());

        return responses;
    }

    public void deletePrescriptionById(Long prescriptionId) {
        prescriptionService.deletePrescriptionById(prescriptionId);
    }

    public List<PrescriptionUiResponse> getAllPrescriptions() {
        List<PrescriptionEntity> prescriptions=prescriptionService.getAllPrescriptions();

        List<PrescriptionUiResponse> response=PrescriptionHelper.convertListOfPrescriptionUiResponse(prescriptions);
        return response;
    }

    public Long addVaccine(VaccineUiRequest request) {
       String vaccineNumber= request.getVaccineNumber();
      boolean successFlag= request.isSuccessFlag();
      String vaccineInfo="";
        if(successFlag)
        {
            vaccineInfo=vaccineInfo+vaccineNumber+":"+"Success|";
        }
        else
        {
            vaccineInfo=vaccineInfo+vaccineNumber+":"+"Failure|";
        }
        VaccineEntity v= VaccineHelper.convertVaccineUiRequest(request);
        v.setVaccineInfo(vaccineInfo);
        Long vaccineId=vaccineService.addVaccine(v);
        return vaccineId;
    }

    public Long updateVaccine(VaccineUiRequest request) {
       Long vaccineId= request.getVaccinationId();
      VaccineEntity vaccineEntity= vaccineService.getByVaccinationId(vaccineId);
     String vaccineInfo= vaccineEntity.getVaccineInfo();
     String vaccineNumber=request.getVaccineNumber();
        boolean successFlag= request.isSuccessFlag();

        if(successFlag)
        {
            vaccineInfo=vaccineInfo+vaccineNumber+":"+"Success|";
        }
        else
        {
            vaccineInfo=vaccineInfo+vaccineNumber+":"+"Failure|";
        }
        vaccineEntity.setVaccineInfo(vaccineInfo);
        vaccineEntity.setVaccineNumber(vaccineNumber);


       return vaccineService.addVaccine(vaccineEntity);
    }

    public List<VaccineUiResponse> getVaccinesByPatientId(Long patientId) {
        List<VaccineEntity> vaccines=vaccineService.getVaccinesByPatientId(patientId);

        List<VaccineUiResponse> responseList=VaccineHelper.convertVaccineListUiResponse(vaccines);
    return responseList;
}

    public Long addInjection(InjectionUiRequest request) {
        InjectionEntity i=InjectionHelper.convertInjectionUiRequest(request);
        Long injectionId=injectionService.addInjection(i);
        return injectionId;
    }

    public List<InjectionUiResponse> getInjectionsByPatientId(Long patientId) {
        List<InjectionEntity> injections=injectionService.getInjectionsByPatientId(patientId);
        List<InjectionUiResponse> responses=InjectionHelper.convertInjectionListUiResponse(injections);
        return responses;
    }

    public List<VaccineTable> getAllVaccines() {
        return vaccineTableRepo.findAll();
    }

	/*	will integrate this once the doctor module is ready

	 * public List<ReferringProviderUiResponse> getNpdiDetails() {





			List<ReferringProviderUiResponse> referringProviderList = new ArrayList<ReferringProviderUiResponse>();



			List<ReferringProvider> listOfRefferal= referringService.getAllReferral();

			for(ReferringProvider referral:listOfRefferal)

			{

				ReferringProviderUiResponse convertToReferringProviderUiResponse = PatientHelper.convertToReferringProviderUiResponse(referral);

				referringProviderList.add(convertToReferringProviderUiResponse);

			}



			return referringProviderList;

		}*/



//    public String searchProvider(String npiNumber) {
//
//        // TODO Auto-generated method stub
//
//        String result=externalService.callApi(npiNumber);
//
//
//
//        return null;
//
//    }



//    public String addReferringProvider(ReferringProviderUiRequest req) {
//
//        // TODO Auto-generated method stub
//
//		/*
//
//			ReferringProvider referringProvider =PatientHelper.conertFromReferringProviderUiRequest(req);
//
//			return referringService.addReferringProvider(referringProvider);
//
//		*/
//
//        return null;
//
//    }
}

