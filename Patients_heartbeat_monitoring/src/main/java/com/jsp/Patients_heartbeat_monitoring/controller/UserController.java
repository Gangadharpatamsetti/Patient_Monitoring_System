package com.jsp.Patients_heartbeat_monitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Patients_heartbeat_monitoring.dto.User;
import com.jsp.Patients_heartbeat_monitoring.service.UserService;
import com.jsp.Patients_heartbeat_monitoring.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}

	@PostMapping("/login")
	    public ResponseEntity<ResponseStructure<User>> loginUser(@RequestBody User user) {
	        return userService.loginUser(user);
	}
	
	 @GetMapping("/getAllUsers")
	    public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
	        return userService.getAllUsers();
	 }
}
