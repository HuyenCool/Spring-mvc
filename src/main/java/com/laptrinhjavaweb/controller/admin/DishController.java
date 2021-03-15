package com.laptrinhjavaweb.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.DishDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IDishService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value= "dishControllerOfAdmin")
public class DishController {
	
	
	@Autowired
	private IDishService dishService;
	
	@Autowired
	private  ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/admin/mon-an/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit, HttpServletRequest request) {
		DishDTO dishDTO = new DishDTO();
		dishDTO.setPage(page);
		dishDTO.setMaxPageItem(limit);
		ModelAndView mav = new ModelAndView("admin/new/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		dishDTO.setListResult(dishService.findAll(pageable));
		dishDTO.setTotalItem(dishService.getTotalItem());
		dishDTO.setTotalPage((int) Math.ceil((double) dishDTO.getTotalItem() / dishDTO.getMaxPageItem()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("dish",dishDTO);
		return mav;
	}	
	
	@RequestMapping(value = "/admin/mon-an/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editDish(@RequestParam(value= "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		DishDTO dishDTO = new DishDTO();
		if(id!= null) {
			dishDTO= dishService.findOne((Long)id);
		}
		
		List<CategoryDTO> categoryDTOs = categoryService.findAll();
		mav.addObject("categories",categoryDTOs);
		mav.addObject("dish",dishDTO );
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}
}
