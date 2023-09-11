package com.aoct.emr.patient.bl;

import com.aoct.emr.appointment.UiResponse.AppointmentUiResponse;
import com.aoct.emr.appointment.bl.AppointmentBl;
import com.aoct.emr.appointment.service.AppointmentService;
import com.aoct.emr.patient.entity.Allergy;
import com.aoct.emr.patient.entity.PatientEntity;
import com.aoct.emr.patient.entity.PatientVitals;
import com.aoct.emr.patient.service.AllergyService;
import com.aoct.emr.patient.service.PatientService;
import com.aoct.emr.patient.service.PatientVitalsService;
import com.aoct.emr.patient.uiRequest.AllergyUiRequest;
import com.aoct.emr.patient.uiRequest.PatientUiRequest;
import com.aoct.emr.patient.uiRequest.PatientVitalsUiRequest;
import com.aoct.emr.patient.uiResponse.AllergyUiResponse;
import com.aoct.emr.patient.uiResponse.PatientUiResponse;
import com.aoct.emr.patient.uiResponse.PatientVitalsUiResponse;
import com.aoct.emr.patient.utility.AllergyHelper;
import com.aoct.emr.patient.utility.PatientHelper;
import com.aoct.emr.patient.utility.PatientVitalsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

        Long allergyId=allergyService.addAllergy(a);
        return allergyId;
    }

    public List<AllergyUiResponse> getPatientAllergy(Long patientId) {
        List<Allergy> allergyList=allergyService.getPatientAllergy(patientId);
        List<AllergyUiResponse> responses=AllergyHelper.convertAllergyListUiResponse(allergyList);
        return responses;
    }

    public Long addVitalsForPatient(PatientVitalsUiRequest patientVitalsUiRequest) {
        PatientVitals v= PatientVitalsHelper.convertPatientVitalsUiRequest(patientVitalsUiRequest);

        Long vitalsId=patientVitalsService.addVitalsForPatient(v);
        return vitalsId;
    }

    public Map<LocalDate,PatientVitalsUiResponse> getVitalsForPatient(Long patientId) {
        List<PatientVitals> vitalslist=patientVitalsService.getVitalsForPatient(patientId);
        Map<LocalDate,PatientVitalsUiResponse> responses=PatientVitalsHelper.convertPatientVitalsListUiResponse(vitalslist);
        return responses;
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

