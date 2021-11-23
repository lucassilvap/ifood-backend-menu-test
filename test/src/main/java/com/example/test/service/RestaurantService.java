package com.example.test.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dto.RestaurantDto;
import com.example.test.exception.RestaurantNotFoundException;
import com.example.test.mapper.RestaurantMapper;
import com.example.test.model.Restaurant;
import com.example.test.repository.RestaurantRepository;
import com.example.test.validationImplemetation.RestauranValidationImp;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantMapper restaurantMapper;
	
	@Autowired
	private RestaurantRepository repository;
	
	@Autowired
	private RestauranValidationImp restauranValidationImp;
	
		
	public RestaurantDto findById(Long id) {
		restauranValidationImp.isAvaliable(id);
		return restaurantMapper.entityForDto(repository.findById(id)
				   .orElseThrow(RestaurantNotFoundException::new)); 
	}
	
	public RestaurantDto disableById(Long id) {
		Restaurant restaurant = repository.findById(id)
				   .orElseThrow(RestaurantNotFoundException::new);
		restaurant.setAvaliable(false);
		return restaurantMapper
		.entityForDto(repository.save(restaurant));			
	}
	
	public RestaurantDto activeById(Long id) {
		Restaurant restaurant = repository.findById(id)
				   .orElseThrow(RestaurantNotFoundException::new);
		
		restaurant.setAvaliable(true);
		 return restaurantMapper
				.entityForDto(repository.save(restaurant));	
	}
	
	public void saveRestaurant(Restaurant restaurant) {
		validateRestaurant(restaurant);
		repository.save(restaurant);
	}
	
	public void validateRestaurant(Restaurant restaurant) {
		restauranValidationImp.restaurantName(restaurant);
	}
	
}
