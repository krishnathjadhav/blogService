package com.blog.blogcontainer.dao;

public class Products{
	private int id;
	private int category_id;
	private String name; 
	private String description;
	private int price;
	
	public  Products(int id ,int category_id, String name,String description,int price) {
		this.id=id;
		this.category_id=category_id;
		this.name=name;
		this.description=description;
		this.price=price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}