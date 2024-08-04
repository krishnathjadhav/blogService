package com.blog.model;

public class User {
    private String name;
    private String password;
    private String role;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.role = "user";
    }
    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

