package com.jsp.Patients_heartbeat_monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Patients_heartbeat_monitoring.dto.PatientHeartRate;
import com.jsp.Patients_heartbeat_monitoring.service.PatientHeartrateService;
import com.jsp.Patients_heartbeat_monitoring.util.ResponseStructure;

@RestController
public class PatientHeartRateController {
	
	@Autowired
	PatientHeartrateService patientHeartrateService;
	
	@PostMapping("/savePatientHeartrate")
	public ResponseEntity<ResponseStructure<PatientHeartRate>> registerUser(@RequestBody PatientHeartRate patientHeartRate) {
		return patientHeartrateService.savePatientHeartrate(patientHeartRate);
	}

}
