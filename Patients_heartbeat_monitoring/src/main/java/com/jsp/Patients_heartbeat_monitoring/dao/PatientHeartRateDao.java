package com.jsp.Patients_heartbeat_monitoring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Patients_heartbeat_monitoring.dto.PatientHeartRate;
import com.jsp.Patients_heartbeat_monitoring.repo.PatientHeartRateRepo;

@Repository
public class PatientHeartRateDao {
	
	@Autowired
	PatientHeartRateRepo patientHeartRateRepo;
	
	public PatientHeartRate savePatientHeartRate(PatientHeartRate patientHeartRate)
	{
		return patientHeartRateRepo.save(patientHeartRate);
		
	}

}
