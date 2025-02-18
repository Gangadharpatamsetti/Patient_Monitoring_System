package com.jsp.Patients_heartbeat_monitoring.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientHeartRate {
	
	@Id
	private int patientId;
	private int patientHeartRate;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getPatientHeartRate() {
		return patientHeartRate;
	}
	public void setPatientHeartRate(int patientHeartRate) {
		this.patientHeartRate = patientHeartRate;
	}
		
}
