package com.blog.blogcontainer.dao;

public class Register{

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	private String name;
	private String password;
	private int id;
	private int mobile;
	private String email;
	private String role;
	
	
	public Register(int id,String name ,int mobile , String email, String role, String password){
		this.id=id;
		this.name=name;
		this.mobile=mobile;
		this.email=email;
		this.role=role;
		this.password=password;
		}
	
	
}