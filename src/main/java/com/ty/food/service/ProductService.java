package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.ProductDao;
import com.ty.food.dto.Product;

@Component
public class ProductService {
	@Autowired
	ProductDao productDao;

	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}

	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	public Product updateProduct(Product product, int id) {
		return productDao.updateProduct(product, id);

	}

	public boolean deleteProduct(int id) {
		return productDao.deleteProduct(id);

	}

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

}
