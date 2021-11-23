package com.example.test.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int quantityOptions;
	
	private double priece;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<ItemGroup> itemGroups;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<AdiditionalItem>  adiditionalItems;
}
