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

@Controller
public class FoodOrderController {
	@Autowired
	FoodOrderService foodOrderService;

	@GetMapping("/loadfoodorder")
	public ModelAndView loadFoodOrder(HttpServletRequest httpServletRequest) {
		List<Item> items=new ArrayList<Item>();
		HttpSession httpSession=httpServletRequest.getSession();
		httpSession.setAttribute("items", items);
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}

	@PostMapping("/")
	public ModelAndView saveFoodOrder(HttpServletRequest httpServletRequest,ModelAndView modelAndView) {
		String itemId=httpServletRequest.getParameter("id");
		String itemName=httpServletRequest.getParameter("name");
		modelAndView.setViewName("");
		
		return modelAndView;
	}

	public ModelAndView getAllFoodOrder() {
		List<FoodOrder> foodOrders = foodOrderService.getAllFoodOrder();
		ModelAndView modelAndView = null;
		if (foodOrders.size() > 0) {
			modelAndView = new ModelAndView();
			modelAndView.addObject("");

		} else {
			modelAndView = new ModelAndView();
			modelAndView.addObject("");

		}
		return modelAndView;
	}

	public ModelAndView deleteFoodOrder() {
		boolean result = foodOrderService.deleteFoodOrder(0);
		ModelAndView modelAndView = null;

		if (result) {
			modelAndView = new ModelAndView();
			modelAndView.addObject("");

		} else {
			modelAndView = new ModelAndView();
			modelAndView.addObject("");

		}
		return modelAndView;
	}
	public ModelAndView updateFoodOrder() {
		FoodOrder foodOrder=foodOrderService.updateFoodOrder(0);
		ModelAndView modelAndView = null;
		if(foodOrder!=null) {
			modelAndView = new ModelAndView();
			modelAndView.addObject("");

		
		}else {
			modelAndView = new ModelAndView();
			modelAndView.addObject("");

		
		}return modelAndView;
	}

}
