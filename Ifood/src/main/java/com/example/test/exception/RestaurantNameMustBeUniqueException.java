package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestaurantNameMustBeUniqueException extends ResponseStatusException {

	public RestaurantNameMustBeUniqueException() {
		super(HttpStatus.BAD_REQUEST, "restaurant name must be unique !!");
		// TODO Auto-generated constructor stub
	}

}
