package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.FoodOrder;

@Component
public class FoodOrderDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return foodOrder;
		
	}
	public List<FoodOrder> getAllFoodOrder() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String sql="select y from FoodOrder y";
		Query query=entityManager.createQuery(sql);
		List<FoodOrder> foodOrders=query.getResultList();
		if(foodOrders.size()>0) {
			return foodOrders;
		}else {
			return null;
		}
	}

	public boolean deleteFoodOrder(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class, id);
		if(foodOrder!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	public FoodOrder updateFoodOrder(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class, id);
		if(foodOrder!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(foodOrder);
			entityTransaction.commit();
			return foodOrder;
		}else {
			return null;
		}
	}
	public FoodOrder getFoodOrderById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class, id);
		if(foodOrder!=null) {
			return foodOrder;
		}else {
			return null;
		}
	}
}
