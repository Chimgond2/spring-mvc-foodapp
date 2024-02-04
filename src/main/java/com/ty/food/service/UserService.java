package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;

@Component
public class UserService {
	@Autowired
	UserDao userDao;

	public User saveUser(User user) {

		return userDao.saveUser(user);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public User updateUserById(User user, int id) {
		return userDao.updateUserById(user, id);
	}

	public boolean deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}
	public List<User> validateUserById(String email, String password) {
		return userDao.validateUserById(email, password);
	}
}
