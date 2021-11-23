package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GroupyMenuNotFoundException extends ResponseStatusException {

	public GroupyMenuNotFoundException() {
		super(HttpStatus.BAD_GATEWAY, "Group Menu not found exception !!");
		// TODO Auto-generated constructor stub
	}

}
