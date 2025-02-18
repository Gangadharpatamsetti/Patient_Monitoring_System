package com.jsp.Patients_heartbeat_monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Patients_heartbeat_monitoring.dao.PatientHeartRateDao;
import com.jsp.Patients_heartbeat_monitoring.dto.PatientHeartRate;
import com.jsp.Patients_heartbeat_monitoring.util.ResponseStructure;

@Service
public class PatientHeartrateService {

	@Autowired
	PatientHeartRateDao patientHeartRateDao;

	public ResponseEntity<ResponseStructure<PatientHeartRate>> savePatientHeartrate(PatientHeartRate patientHeartRate) {
		ResponseStructure<PatientHeartRate> responseStructure = new ResponseStructure<PatientHeartRate>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully PatientHeartrate Saved");
		responseStructure.setData(patientHeartRateDao.savePatientHeartRate(patientHeartRate));
		return new ResponseEntity<ResponseStructure<PatientHeartRate>>(responseStructure, HttpStatus.CREATED);
	}
}
