package com.camcar.rest.webservices.restfulwebservices.user;


//@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
