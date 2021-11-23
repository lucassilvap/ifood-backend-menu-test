package com.example.test.mapper;

import javax.persistence.Entity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dto.RestaurantDto;
import com.example.test.model.Restaurant;

@Service
public class RestaurantMapper {

	@Autowired
	private ModelMapper mapper;
	
	public RestaurantDto entityForDto(Restaurant restaurant) {
	 return mapper.map(restaurant, RestaurantDto.class);	
	}
}
