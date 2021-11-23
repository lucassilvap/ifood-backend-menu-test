package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestaurantNotFoundException extends ResponseStatusException {

	public RestaurantNotFoundException() {
		super(HttpStatus.BAD_REQUEST, "restaurant not found exception !!");
		// TODO Auto-generated constructor stub
	}

}
