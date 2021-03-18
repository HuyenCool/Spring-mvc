package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategorytyRepository;
import com.laptrinhjavaweb.repository.DishRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	
	@Autowired
	private CategorytyRepository categorytyRepository;
	
	@Autowired
	private DishRepository dishRepository;
	
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


	@Override
	@Transactional
	public CategoryDTO save_update(CategoryDTO categoryDTO) {
		CategoryEntity newCategoryEntity = new CategoryEntity();
		if (categoryDTO.getId() != null) {
			CategoryEntity oldCategoryEntity = categorytyRepository.findOne(categoryDTO.getId());
			newCategoryEntity = categoryConverter.toCategoryEntity(categoryDTO, oldCategoryEntity);
		} else {
			newCategoryEntity = categoryConverter.toCategoryEntity(categoryDTO);	
		}
		CategoryDTO newCategoryDTO = categoryConverter.toCategoryDTO(categorytyRepository.save(newCategoryEntity));
		return newCategoryDTO;
	}


	@Override
	@Transactional
	public void delete(long[] ids) {
		
		
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			//dishRepository.deleteByIdCategory(id);
			categorytyRepository.delete(id);
		}
	}


	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		List<CategoryEntity> categoryEntitys  = categorytyRepository.findAll(pageable).getContent();
		for(CategoryEntity item : categoryEntitys) {
			categoryDTOs.add(categoryConverter.toCategoryDTO(item));
		}
		return categoryDTOs;
	}


	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) categorytyRepository.count();
	}


	@Override
	public CategoryDTO findOne(Long id) {
		CategoryEntity categoryEntity = categorytyRepository.findOne(id);
		return categoryConverter.toCategoryDTO(categoryEntity);
	}

}
