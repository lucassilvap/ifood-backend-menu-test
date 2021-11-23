package com.example.test.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	private String name;
	
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	private Menu menu;
	
	private boolean isAvaliable;
	
	@PrePersist
	public void updateMenu() {
	   menu.setRestaurant(this);	
	}

}
