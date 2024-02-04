package com.ty.food.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cost;
	private int quandity;
	@ManyToOne
	@JoinColumn
	private FoodOrder order;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public int getQuandity() {
		return quandity;
	}
	public void setQuandity(int quandity) {
		this.quandity = quandity;
	}
	public FoodOrder getOrder() {
		return order;
	}
	public void setOrder(FoodOrder order) {
		this.order = order;
	}
	
	
}
