package com.example.test.dto;
import com.example.test.model.Menu;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class RestaurantDto {

    Long id;
    
	private String name;
	
	private Menu menu;
	
	private boolean isAvaliable;
}