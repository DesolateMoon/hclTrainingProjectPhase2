package com.model;

public class Product {
	private int id;
	private String name;
	private String department;
	private double cost;
	
	public Product() {
		super();
	}

	public Product(int id, String name, String department, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.cost = cost;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", department=" + department + ", cost=" + cost + "]";
	}
}
