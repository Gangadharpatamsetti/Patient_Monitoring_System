package com.jsp.Patients_heartbeat_monitoring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Patients_heartbeat_monitoring.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	 User findByEmail(String email);
	 boolean existsByEmail(String email);

}
