package com.laptrinhjavaweb.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.ICategoryService;
@RestController(value = "categoryAPIOfAdmin")
public class CategoryApi {
	
	@Autowired
	private ICategoryService categoryService;
	
	
	@PostMapping(value = "/api/the-loai")
	public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
		CategoryDTO categoryDTO = categoryService.save_update(category);
		return categoryDTO;
	   }
	
	
	@PutMapping(value = "/api/the-loai")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO category) {
		return categoryService.save_update(category);
	   }
	
	
	@DeleteMapping(value = "/api/the-loai")
	public void deleteCategory(@RequestBody long[] ids) {
		categoryService.delete(ids);
	   }
}
