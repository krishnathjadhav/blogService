package com.blog.blogcontainer.dao;

public class AddToCart{
	private int id;
	private int user_id;
	private String products;
	private int noOfItems;
	private int billing_amount;
	
	public AddToCart(int id,int user_id,String products,int noOfItems,int billing_amount) {
		this.id=id;
		this.user_id=user_id;
		this.products=products;
		this.noOfItems=noOfItems;
		this.billing_amount=billing_amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public int getBilling_amount() {
		return billing_amount;
	}

	public void setBilling_amount(int billing_amount) {
		this.billing_amount = billing_amount;
	}
}
