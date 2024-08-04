package com.blog.model.response;

public class LoginRes {
    private String name;
    private String token;



    private String role;

    public LoginRes(String name, String token, String role) {
        this.name = name;
        this.token = token;
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
