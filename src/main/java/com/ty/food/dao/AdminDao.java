package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ty.food.dto.Admin;

@Repository
public class AdminDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Admin saveAdmin(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();

		return admin;
	}

	public Admin validateAdmin(String email, String password) {
		String sql = "select t from Admin t where t.email=?1 and t.password=?2";
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Admin> admins = query.getResultList();
		if (admins.size() > 0) {
			return admins.get(0);
		} else {
			return null;
		}
	}

}
