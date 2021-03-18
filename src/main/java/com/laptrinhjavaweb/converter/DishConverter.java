package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.DishDTO;
import com.laptrinhjavaweb.entity.DishEntity;

@Component
public class DishConverter {

	public DishEntity toDishEntity(DishDTO dishDTO) {
		
		DishEntity  dishEntity = new DishEntity();
		dishEntity.setTitle(dishDTO.getTitle());
		dishEntity.setThumbnail(dishDTO.getThumbnail());
		dishEntity.setShortdescription(dishDTO.getShortdescription());
		dishEntity.setContent(dishDTO.getContent());
		
		return dishEntity;
	}
	
	public DishDTO toDishDTO(DishEntity dishEntity) {
		
		DishDTO dishDTO = new DishDTO();
		
		if(dishEntity.getId()!= null) {
			dishDTO.setId(dishEntity.getId());
		}
		dishDTO.setTitle(dishEntity.getTitle());
		dishDTO.setThumbnail(dishEntity.getThumbnail());
		dishDTO.setShortdescription(dishEntity.getShortdescription());
		dishDTO.setContent(dishEntity.getContent());
		dishDTO.setCategoryCode(dishEntity.getCategory().getCode());
		dishDTO.setCreatedBy(dishEntity.getCreatedBy());
		dishDTO.setModifiedBy(dishEntity.getModifiedBy());
		dishDTO.setCreatedDate(dishEntity.getCreatedDate());
		dishDTO.setModifiedDate(dishEntity.getModifiedDate());
		return dishDTO;
		
	}
	
	public DishEntity toDishEntity(DishDTO dishDTO, DishEntity oldDishEntity) {

		oldDishEntity.setTitle(dishDTO.getTitle());
		oldDishEntity.setThumbnail(dishDTO.getThumbnail());
		oldDishEntity.setShortdescription(dishDTO.getShortdescription());
		oldDishEntity.setContent(dishDTO.getContent());
		
		return oldDishEntity;
	}
}
