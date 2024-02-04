package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Product;

@Component
public class ProductDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Product saveProduct(Product product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		return product;
	}

	public List<Product> getAllProduct() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select u from Product u";
		Query query = entityManager.createQuery(sql);
		List<Product> products = query.getResultList();
		if (products != null) {
			return products;
		} else {
			return null;
		}
	}

	public Product updateProduct(Product product, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product product2 = entityManager.find(Product.class, id);
		if (product2 != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(product);
			entityTransaction.commit();
			return product;
		} else {
			return null;
		}

	}

	public boolean deleteProduct(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product product = entityManager.find(Product.class, id);
		if (product != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(product);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}

	}

	public Product getProductById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, id);
		if (product != null) {
			return product;
		}else {
			return null;
		}
	}
}
