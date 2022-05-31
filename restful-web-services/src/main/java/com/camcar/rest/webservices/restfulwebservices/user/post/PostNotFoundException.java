package com.camcar.rest.webservices.restfulwebservices.user.post;


//@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

	
	public PostNotFoundException(String msg) {
		super(msg);
	}
}
