package com.jsp.Patients_heartbeat_monitoring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashing {
	
	    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	    public static String hashPassword(String password) {
	        return encoder.encode(password);
	    }

	    public static boolean checkPassword(String rawPassword, String hashedPassword) {
	        return encoder.matches(rawPassword, hashedPassword);
	    }
	}


