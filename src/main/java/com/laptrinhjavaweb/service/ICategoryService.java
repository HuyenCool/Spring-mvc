package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.CategoryDTO;
public interface ICategoryService {
	CategoryDTO findOneByCode(String code);
	List<CategoryDTO> findAll();
	CategoryDTO save_update(CategoryDTO categoryDTO);
	void delete(long[] ids);
	List<CategoryDTO> findAll(Pageable pageable);
	int getTotalItem();
	CategoryDTO findOne(Long id);
}
