package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.FoodOrder;

@Component
public class FoodOrderService {
	@Autowired
	FoodOrderService foodOrderService;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderService.getAllFoodOrder();
	}

	public boolean deleteFoodOrder(int id) {
		return foodOrderService.deleteFoodOrder(id);
	}

	public FoodOrder updateFoodOrder(int id) {
		return foodOrderService.updateFoodOrder(id);
	}

	public FoodOrder getFoodOrderById(int id) {
		return foodOrderService.getFoodOrderById(id);
	}

}
