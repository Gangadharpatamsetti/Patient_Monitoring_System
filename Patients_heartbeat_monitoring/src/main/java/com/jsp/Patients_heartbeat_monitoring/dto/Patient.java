package com.jsp.Patients_heartbeat_monitoring.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	private String patientName;
	private String patientDob;
	
	@OneToOne
	private PatientHeartRate heartRate;

	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientDob() {
		return patientDob;
	}
	public void setPatientDob(String patientDob) {
		this.patientDob = patientDob;
	}
	public PatientHeartRate getHeartRates() {
		return heartRate;
	}
	public void setHeartRates(PatientHeartRate heartRate) {
		this.heartRate = heartRate;
	}

}
