package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ty.food.dao.AdminDao;
import com.ty.food.dto.Admin;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;

	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	public Admin validateAdmin(String email, String password) {
		return adminDao.validateAdmin(email, password);
	}

}
