package com.jsp.Patients_heartbeat_monitoring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Patients_heartbeat_monitoring.dto.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
