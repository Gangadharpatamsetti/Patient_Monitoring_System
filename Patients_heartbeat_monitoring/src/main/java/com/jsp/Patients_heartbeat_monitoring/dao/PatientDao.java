package com.jsp.Patients_heartbeat_monitoring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Patients_heartbeat_monitoring.dto.Patient;
import com.jsp.Patients_heartbeat_monitoring.repo.PatientRepo;

@Repository
public class PatientDao {

	@Autowired
	PatientRepo patientRepo;

	public Patient registerPatient(Patient patient) {
		return patientRepo.save(patient);

	}
	
	 public List<Patient> findAllPatients() {
	        return patientRepo.findAll();  
	    }

}
