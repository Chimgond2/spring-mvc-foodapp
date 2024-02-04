package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;
import com.ty.food.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	FoodOrderService foodOrderService;
	
	////////save item//////////////////
	@GetMapping("additem")
	public ModelAndView loadItem(HttpServletRequest httpServletRequest,ModelAndView modelAndView) {
		List<Item> items=new ArrayList<Item>();
		HttpSession httpSession=httpServletRequest.getSession();
		httpSession.setAttribute("items", items);
		modelAndView.setViewName("");
		return modelAndView;
	}
	@PostMapping("/saveditem")
	public ModelAndView loaItem(HttpServletRequest httpServletRequest,ModelAndView modelAndView) {
		String itemId=httpServletRequest.getParameter("id");
		String itemName=httpServletRequest.getParameter("name");
		modelAndView.addObject("id",itemId);
		modelAndView.addObject("itemname",itemName);
		modelAndView.setViewName("");
		FoodOrder  foodOrder=foodOrderService.getFoodOrderById(Integer.parseInt(itemId));
		HttpSession httpSession=httpServletRequest.getSession();
		httpSession.setAttribute("foodorder", foodOrder);
		return modelAndView.addObject("item",new Item());
		}
	
	public ModelAndView getAllItem() {
		List<Item> items=itemService.getAllItem();
		ModelAndView modelAndView=null;
		if(items.size()>0) {
			modelAndView=new ModelAndView();
			modelAndView.addObject(modelAndView);
		}else {
			modelAndView=new ModelAndView();
			modelAndView.addObject(modelAndView);
		
		}
		return modelAndView;
	}

	public ModelAndView getItemById() {
		Item  item=itemService.getItemById(0);
		ModelAndView modelAndView=null;
		if(item!=null) {
			modelAndView=new ModelAndView();
			modelAndView.addObject("");
		}else {
			modelAndView=new ModelAndView();
			modelAndView.addObject("");
		
		}
		return modelAndView;
	}
	public ModelAndView deleteItemById() {
		boolean result=itemService.deleteItemById(0);
		ModelAndView modelAndView=null;
		if(result) {
			modelAndView=new ModelAndView();
			modelAndView.addObject("");
		}else {
			modelAndView=new ModelAndView();
			modelAndView.addObject("");
			
		}
		return modelAndView;
	}
	public ModelAndView updateItemById() {
		Item item=itemService.updateItemById(0);
		ModelAndView modelAndView=null;
		if(item!=null) {
			modelAndView=new ModelAndView();
			modelAndView.addObject("");
		}else {
			modelAndView=new ModelAndView();
			modelAndView.addObject("");
		
		}
		return modelAndView;
	}

	
}
