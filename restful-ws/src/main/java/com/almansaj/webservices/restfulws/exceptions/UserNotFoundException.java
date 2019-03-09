package com.almansaj.webservices.restfulws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6915316576651097392L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
