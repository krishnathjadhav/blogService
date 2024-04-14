package com.blog.blogcontainer.dao;


public class Cart {


    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    private int id;

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public int getProduct() {
        return product;
    }

    public int getAmmount() {
        return ammount;
    }

    private String user;
    private int product;
    private int ammount;
    public Cart(int id, String user, int product, int ammount) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.ammount = ammount;
    }

}
