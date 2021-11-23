package com.example.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	private List<GroupMenu> groupMenu;
	
	@JsonBackReference
	@OneToOne
	private Restaurant restaurant;
	
	@PostPersist
	public void update () {
		groupMenu.forEach(gp -> gp.setMenu(this));
	}

}
