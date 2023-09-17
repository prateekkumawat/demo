package com.aoct.emr.patient.controller;

import com.aoct.emr.patient.bl.GuarantorBl;
import com.aoct.emr.patient.uiRequest.GuarantorUiRequest;
import com.aoct.emr.patient.uiResponse.GuarantorUiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guarantor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})

public class GuarantorController {
    @Autowired
    GuarantorBl bl;

    @PostMapping("/createGuarantor")
    public Long createGuarantor(@RequestBody GuarantorUiRequest guarantorUiRequest){
    return bl.createGuarantor(guarantorUiRequest);
    }
    @GetMapping("/getGuarantor/{guarantorId}")
    public GuarantorUiResponse getGuarantor(@PathVariable Long guarantorId){
        return  bl.getGuarantor(guarantorId);
    }

    @GetMapping("/getAllGuarantor")
    public List<GuarantorUiResponse> getAllGuarantor(){
        return  bl.getAllGuarantor();

    }

}
