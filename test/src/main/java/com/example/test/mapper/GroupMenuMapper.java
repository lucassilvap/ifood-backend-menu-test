package com.example.test.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.dto.GroupMenuDto;
import com.example.test.model.GroupMenu;

@Service
public class GroupMenuMapper {

	@Autowired
	private ModelMapper mapper;
	
	public GroupMenuDto entityForDto(GroupMenu groupMenu) {
	 return mapper.map(groupMenu, GroupMenuDto.class);	
	}
}
