package com.example.test.dto;
import java.util.List;
import com.example.test.model.Item;
import lombok.Data;

@Data
public class GroupMenuDto {

	private Long id;
	
	private String description;
	
	private List<Item> items;

}
