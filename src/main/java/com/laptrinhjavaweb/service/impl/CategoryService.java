package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategorytyRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	
	@Autowired
	private CategorytyRepository categorytyRepository;
	
	@Autowired 
	private CategoryConverter categoryConverter;
	
	@Override
	public CategoryDTO findOneByCode(String code) {
		CategoryEntity CategoryEntity = categorytyRepository.findOneByCode(code);
		return categoryConverter.toCategoryDTO(CategoryEntity);
	}
	
	
	@Override
	public List<CategoryDTO> findAll() {
		
		List<CategoryEntity> categoryEntitys = categorytyRepository.findAll();
		
		List<CategoryDTO> CategoryDTOs = new ArrayList<>();
		for(CategoryEntity i : categoryEntitys) {
			CategoryDTOs.add(categoryConverter.toCategoryDTO(i));
		}
		
		return CategoryDTOs;
	}

}
