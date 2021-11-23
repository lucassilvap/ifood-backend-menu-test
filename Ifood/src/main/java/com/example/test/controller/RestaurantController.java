package com.example.test.controller;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.AdiditionalItem;
import com.example.test.model.GroupMenu;
import com.example.test.model.Item;
import com.example.test.model.ItemGroup;
import com.example.test.model.Menu;
import com.example.test.model.OptionItemGroupy;
import com.example.test.model.Restaurant;
import com.example.test.service.RestaurantService;

@RequestMapping("restaurant")
@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("disable/{id}")
	public ResponseEntity<?> disable(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(service.disableById(id));
	}
	
	@PutMapping("active/{id}")
	public ResponseEntity<?> active(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(service.activeById(id));
	}

	@PostConstruct
	public void constructBaseData() {
		
		  Restaurant restaurant = new Restaurant();
		  restaurant.setName("Restaurante do seu Zé");
		  restaurant.setAvaliable(true);
		  
		  List<GroupMenu> optionsMenus = new ArrayList<GroupMenu>();
		  GroupMenu groupMenu1 = new GroupMenu();
		  
		  groupMenu1.setDescription("sopas"); 
		  List<Item> prates = new ArrayList<>();
		  List<AdiditionalItem>adiditionalItems = new ArrayList<AdiditionalItem>();
		  AdiditionalItem adiditionalItem = new AdiditionalItem();
		  adiditionalItem.setName("cutlery");
		  adiditionalItem.setFree(true);
		  adiditionalItem.setPresent(true);
		  adiditionalItems.add(adiditionalItem);
		  groupMenu1.setItems(prates);
		  Item prate1 = new Item();
		  prate1.setName("sopa01");
		  prate1.setQuantityOptions(3);
		  prate1.setAdiditionalItems(adiditionalItems);
		  List<ItemGroup> itensGroupPrate1 = new ArrayList<ItemGroup>();
		  ItemGroup itemGroup1Prate1 = new ItemGroup();
		  itemGroup1Prate1.setDescription("temperos");
		  List<OptionItemGroupy> spices = new ArrayList<OptionItemGroupy>();
		  OptionItemGroupy spice1 = new OptionItemGroupy();
		  spice1.setName("pickles");
		  spices.add(spice1);
		  
		  itensGroupPrate1.add(itemGroup1Prate1);
		  
		  itemGroup1Prate1.setGroupy(spices);
		  prate1.setItemGroups(itensGroupPrate1);
		  prates.add(prate1);
		  
		  optionsMenus.add(groupMenu1);
		  Menu menu = new Menu();
		  menu.setGroupMenu(optionsMenus);
		  restaurant.setMenu(menu);  
	      service.saveRestaurant(restaurant);   		
	}
	
}
