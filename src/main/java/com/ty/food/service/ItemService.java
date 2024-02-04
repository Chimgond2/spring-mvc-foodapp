package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.ItemDao;
import com.ty.food.dto.Item;
@Component
public class ItemService {
	@Autowired
	ItemDao itemDao;

	public Item saveItem(Item item) {
		return itemDao.saveItem(item);
	}

	public List<Item> getAllItem() {
		return itemDao.getAllItem();
	}

	public Item getItemById(int id) {
		return itemDao.getItemById(id);
	}

	public Item updateItemById(int id) {
		return itemDao.updateItemById(id);

	}

	public boolean deleteItemById(int id) {

		return itemDao.deleteItemById(id);
	}

}
