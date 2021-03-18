package com.laptrinhjavaweb.controller.admin;


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
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.util.MessageUtil;



@Controller(value= "categoryControllerOfAdmin")
public class CategoryControllers {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	
	@RequestMapping(value = "/admin/the-loai/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setPage(page);
		categoryDTO.setMaxPageItem(limit);
		ModelAndView mav = new ModelAndView("admin/category/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		categoryDTO.setListResult(categoryService.findAll(pageable));
		categoryDTO.setTotalItem(categoryService.getTotalItem());
		categoryDTO.setTotalPage((int) Math.ceil((double) categoryDTO.getTotalItem() / categoryDTO.getMaxPageItem()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("category",categoryDTO);
		return mav;
	}
	
	@RequestMapping(value = "/admin/the-loai/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editDish(@RequestParam(value= "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		CategoryDTO categoryDTO = new CategoryDTO();
		if(id!= null) {
			categoryDTO= categoryService.findOne((Long)id);
		}
		
		mav.addObject("category",categoryDTO );
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;

	}
}
