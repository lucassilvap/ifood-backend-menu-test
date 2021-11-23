package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestaurantDisabledException extends ResponseStatusException {

	public RestaurantDisabledException() {
		super(HttpStatus.BAD_GATEWAY, "restaurant disabled exception");
		// TODO Auto-generated constructor stub
	}

}
