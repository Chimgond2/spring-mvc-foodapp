package com.ty.food.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.User;

@Component
public class UserDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public User saveUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;

	}

	public List<User> getAllUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select y from User y";
		Query query = entityManager.createQuery(sql);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}

	public User updateUserById(User user, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user2 = entityManager.find(User.class, id);
		if (user2 != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return user;
		} else {
			return null;
		}
	}

	public boolean deleteUserById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user2 = entityManager.find(User.class, id);
		if (user2 != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(user2);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public List<User> validateUserById(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select y from User y where y.email=?1 and y.password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}

}
