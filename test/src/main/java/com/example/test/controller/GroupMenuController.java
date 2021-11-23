package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.service.GroupMenuService;

@RestController
@RequestMapping("groupyMenu")
public class GroupMenuController {
	
	@Autowired
	private GroupMenuService groupService;
	
	@GetMapping("{id}")
	public ResponseEntity<?> findByID(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(groupService.findById(id));
	}
	

}
