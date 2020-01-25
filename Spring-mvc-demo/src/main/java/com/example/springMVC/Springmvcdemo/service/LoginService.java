package com.example.springMVC.Springmvcdemo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("Abhi") && password.equalsIgnoreCase("dummy");
	}

}
