package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Item;

@Component
public class ItemDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Item saveItem(Item item) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
		return item;

	}

	public List<Item> getAllItem() {
		String sql = "select y from Item y";
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery(sql);
		List<Item> items = query.getResultList();
		if (items.size() > 0) {
			return items;
		} else {
			return null;
		}
	}

	public Item getItemById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Item item = entityManager.find(Item.class, id);
		if (item != null) {
			return item;
		} else {
			return null;
		}
	}

	public Item updateItemById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Item item = entityManager.find(Item.class, id);
		if (item != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(item);
			entityTransaction.commit();
			return item;
		} else {
			return null;
		}

	}

	public boolean deleteItemById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Item item = entityManager.find(Item.class, id);
		if (item != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}

	}

}
