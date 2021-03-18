package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.DishConverter;
import com.laptrinhjavaweb.dto.DishDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.DishEntity;
import com.laptrinhjavaweb.repository.CategorytyRepository;
import com.laptrinhjavaweb.repository.DishRepository;
import com.laptrinhjavaweb.service.IDishService;

@Service
public class DishService implements IDishService {

	@Autowired
	private DishRepository dishRepository;
	
	@Autowired
	private DishConverter dishConverter;
	
	@Autowired
	private CategorytyRepository categorytyRepository;
	
	@Override
	@Transactional
	public DishDTO save_update(DishDTO dishDTO) {
		
		CategoryEntity categoryEntity = categorytyRepository.findOneByCode(dishDTO.getCategoryCode());
		DishEntity newDishEntity = new DishEntity();
		if (dishDTO.getId() != null) {
			DishEntity oldDishEntity = dishRepository.findOne(dishDTO.getId());
			oldDishEntity.setCategory(categoryEntity);
			newDishEntity = dishConverter.toDishEntity(dishDTO, oldDishEntity);
		} else {
			newDishEntity = dishConverter.toDishEntity(dishDTO);
			newDishEntity.setCategory(categoryEntity);
		}
		return dishConverter.toDishDTO(dishRepository.save(newDishEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			dishRepository.delete(id);
		}
		
	}

	@Override
	public List<DishDTO> findAll(Pageable pageable) {
		List<DishDTO> dishDTOs = new ArrayList<>();
		List<DishEntity> dishEntitys  = dishRepository.findAll(pageable).getContent();
		for(DishEntity item : dishEntitys) {
			dishDTOs.add(dishConverter.toDishDTO(item));
		}
		return dishDTOs;
	}

	@Override
	public int getTotalItem() {
		
		return (int) dishRepository.count();
	}

	@Override
	public List<DishDTO> findAll() {
		List<DishDTO> dishDTOs = new ArrayList<>();
		List<DishEntity> dishEntitys  = dishRepository.findAll();
		for(DishEntity item : dishEntitys) {
			dishDTOs.add(dishConverter.toDishDTO(item));
		}
		return dishDTOs;
		
	}

	@Override
	public DishDTO findOne(Long id) {
		DishEntity dishEntity = dishRepository.findOne(id);
		System.out.print("Huyennn" + dishEntity.getCategory().getCode());
		return dishConverter.toDishDTO(dishEntity);
	}

}
