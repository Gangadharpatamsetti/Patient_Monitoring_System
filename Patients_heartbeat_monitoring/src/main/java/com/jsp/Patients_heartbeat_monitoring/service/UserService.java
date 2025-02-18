package com.jsp.Patients_heartbeat_monitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Patients_heartbeat_monitoring.dao.UserDao;
import com.jsp.Patients_heartbeat_monitoring.dto.User;
import com.jsp.Patients_heartbeat_monitoring.util.PasswordHashing;
import com.jsp.Patients_heartbeat_monitoring.util.ResponseStructure;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;
	
	
	public ResponseEntity<ResponseStructure<User>> registerUser(User user) {
		String userPassword=PasswordHashing.hashPassword(user.getPassword());
		user.setPassword(userPassword);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully user Registered");
		responseStructure.setData(userDao.registerUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> loginUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		
		User existingUser = userDao.findByEmail(user.getEmail());
		if (existingUser == null) {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User not found with this email.");
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
        
		if (!PasswordHashing.checkPassword(user.getPassword(), existingUser.getPassword())) {
			responseStructure.setStatus(HttpStatus.UNAUTHORIZED.value());
			responseStructure.setMessage("Invalid password.");
			return new ResponseEntity<>(responseStructure, HttpStatus.UNAUTHORIZED);
		}

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Login successful");
		responseStructure.setData(existingUser);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	
	 public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
	        ResponseStructure<List<User>> responseStructure = new ResponseStructure<>();
	        List<User> users = userDao.findAllUsers();
	        responseStructure.setStatus(HttpStatus.OK.value());
	        responseStructure.setMessage("Users fetched successfully");
	        responseStructure.setData(users);
	        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	    }

}
