package com.example.learnspringboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password)
	{
		boolean isValidUserName = username.equalsIgnoreCase("utsav");
		boolean isValidPassword = password.equalsIgnoreCase("tyagi");
		
		return isValidUserName && isValidPassword;
	}

}
