package com.mph.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserNotFound. Plz check the Credential You entered ";
	}
	
	

}
