package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {

		CategoryDTO categoryDTO = new CategoryDTO();

		if (categoryEntity.getId() != null) {
			categoryDTO.setId(categoryEntity.getId());
		}
		categoryDTO.setName(categoryEntity.getName());
		categoryDTO.setCode(categoryEntity.getCode());
		categoryDTO.setCreatedBy(categoryEntity.getCreatedBy());
		categoryDTO.setModifiedBy(categoryEntity.getModifiedBy());
		categoryDTO.setCreatedDate(categoryEntity.getCreatedDate());
		categoryDTO.setModifiedDate(categoryEntity.getModifiedDate());
		return categoryDTO;

	}
}
