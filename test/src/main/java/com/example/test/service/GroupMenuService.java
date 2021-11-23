package com.example.test.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dto.GroupMenuDto;
import com.example.test.exception.GroupyMenuNotFoundException;
import com.example.test.mapper.GroupMenuMapper;
import com.example.test.model.GroupMenu;
import com.example.test.repository.GroupMenuRepository;
import com.example.test.validation.validationRestaurant;

@Service
public class GroupMenuService {

	@Autowired
	private GroupMenuRepository groupMenuRepository;
	
	@Autowired
	private validationRestaurant validationRestaurant;
	
	@Autowired
	private GroupMenuMapper groupMenuMapper;
	
	public GroupMenuDto findById (Long id){
		GroupMenu groupMenu = groupMenuRepository.findById(id)
		.orElseThrow(GroupyMenuNotFoundException::new);
		validationRestaurant.isAvaliable(
		groupMenu.getMenu().getRestaurant().getId());
		return groupMenuMapper.entityForDto(groupMenu);
	}
}
