package com.laptrinhjavaweb.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.DishDTO;
import com.laptrinhjavaweb.service.IDishService;

@RestController(value = "dishAPIOfAdmin")
public class DishApi {

	@Autowired
	private IDishService dishService;
	
	
	@PostMapping(value = "/api/mon-an")
	public DishDTO createNew(@RequestBody DishDTO dish) {
		DishDTO dishDTO = dishService.save_update(dish);
		return dishDTO;
	   }
	
	@PutMapping(value = "/api/mon-an")
	public DishDTO updateNew(@RequestBody DishDTO dish) {
		DishDTO dishDTO = dishService.save_update(dish);
	    return dishDTO;
	   }
	
	
	@DeleteMapping(value = "/api/mon-an")
	public void deleteNew(@RequestBody long[] ids) {
		dishService.delete(ids);
	   }
}
