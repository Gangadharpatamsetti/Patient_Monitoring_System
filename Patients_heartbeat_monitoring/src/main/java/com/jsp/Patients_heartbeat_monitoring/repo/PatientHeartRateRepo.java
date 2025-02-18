package com.jsp.Patients_heartbeat_monitoring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Patients_heartbeat_monitoring.dto.PatientHeartRate;

public interface PatientHeartRateRepo extends JpaRepository<PatientHeartRate, Integer>{

}
