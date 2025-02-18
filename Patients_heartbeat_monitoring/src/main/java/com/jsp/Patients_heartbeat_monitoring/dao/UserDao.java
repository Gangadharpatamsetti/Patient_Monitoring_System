package com.jsp.Patients_heartbeat_monitoring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Patients_heartbeat_monitoring.dto.User;
import com.jsp.Patients_heartbeat_monitoring.repo.PatientRepo;
import com.jsp.Patients_heartbeat_monitoring.repo.UserRepo;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserDao {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PatientRepo patientRepo;
	
	public User registerUser(User user) {
		 if (userRepo.existsByEmail(user.getEmail())) {
	            throw new RuntimeException("User already Exists");
	        }
	        return userRepo.save(user);
	}
	
	public User findByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}
	public List<User> findAllUsers() {
        return userRepo.findAll();
	}
}	

