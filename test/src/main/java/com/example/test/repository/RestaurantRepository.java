package com.example.test.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.test.model.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

	Optional<Restaurant> findByName(String name);
}
