package com.jsp.Patients_heartbeat_monitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Patients_heartbeat_monitoring.dao.PatientDao;
import com.jsp.Patients_heartbeat_monitoring.dto.Patient;
import com.jsp.Patients_heartbeat_monitoring.util.ResponseStructure;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientService {

	@Autowired
	PatientDao patientDao;

	public ResponseEntity<ResponseStructure<Patient>> registerPatient(Patient patient) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully Patient Registered");
		responseStructure.setData(patientDao.registerPatient(patient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatients() {
		ResponseStructure<List<Patient>> responseStructure = new ResponseStructure<>();
		List<Patient> patients = patientDao.findAllPatients();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Patients fetched successfully");
		responseStructure.setData(patients);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
}
