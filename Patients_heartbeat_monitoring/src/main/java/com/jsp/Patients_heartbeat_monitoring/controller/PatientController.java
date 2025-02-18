package com.jsp.Patients_heartbeat_monitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Patients_heartbeat_monitoring.dto.Patient;

import com.jsp.Patients_heartbeat_monitoring.service.PatientService;
import com.jsp.Patients_heartbeat_monitoring.util.ResponseStructure;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@PostMapping("/registerPatient")
	public ResponseEntity<ResponseStructure<Patient>> registerUser(@RequestBody Patient patient) {
		return patientService.registerPatient(patient);
	}
	
	@GetMapping("/getAllPatients")
    public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatients() {
        return patientService.getAllPatients();
    }
}