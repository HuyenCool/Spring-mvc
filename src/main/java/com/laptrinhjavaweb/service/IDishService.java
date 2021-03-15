package com.laptrinhjavaweb.service;



import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.DishDTO;




public interface IDishService {
	DishDTO save_update(DishDTO dishDTO);
	void delete(long[] ids);
	List<DishDTO> findAll(Pageable pageable);
	List<DishDTO> findAll();
	int getTotalItem();
	DishDTO findOne(Long id);
}
