package com.aoct.emr.patient.bl;

import com.aoct.emr.appointment.UiResponse.AppointmentUiResponse;
import com.aoct.emr.appointment.bl.AppointmentBl;
import com.aoct.emr.appointment.service.AppointmentService;
import com.aoct.emr.patient.entity.PatientEntity;
import com.aoct.emr.patient.service.PatientService;
import com.aoct.emr.patient.uiRequest.PatientUiRequest;
import com.aoct.emr.patient.uiResponse.PatientUiResponse;
import com.aoct.emr.patient.utility.PatientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientBl {


    @Autowired
    PatientService service;

    @Autowired
    AppointmentBl appointmentBl;

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

