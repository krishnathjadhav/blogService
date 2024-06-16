package com.blog.blogcontainer.dao;


public class Cart {


    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setProduct(String product) {
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

    public String getProduct() {
        return product;
    }

    public int getAmmount() {
        return ammount;
    }

    private String user;
    private String product;
    private int ammount;
    public Cart(int id, String user, String product, int ammount) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.ammount = ammount;
    }

}
