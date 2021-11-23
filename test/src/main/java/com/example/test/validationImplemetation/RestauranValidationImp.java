package com.example.test.validationImplemetation;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.exception.RestaurantDisabledException;
import com.example.test.exception.RestaurantNameMustBeUniqueException;
import com.example.test.exception.RestaurantNotFoundException;
import com.example.test.model.Restaurant;
import com.example.test.repository.RestaurantRepository;
import com.example.test.validation.validationRestaurant;

@Service
public class RestauranValidationImp implements validationRestaurant {

	@Autowired
	private RestaurantRepository repository;
	
	@Override
	public void restaurantName(Restaurant restaurant) {
	  if (repository.findByName(restaurant.getName()).isPresent())
	  throw new RestaurantNameMustBeUniqueException();
	}
	
	@Override
	public void isAvaliable(Long id) {
		Optional<Restaurant> optionalRestaurant = repository.findById(id);
		Restaurant restaurant = optionalRestaurant.orElseThrow(RestaurantNotFoundException::new);
		if ( !restaurant.isAvaliable() )
		throw new RestaurantDisabledException();
	}

}
