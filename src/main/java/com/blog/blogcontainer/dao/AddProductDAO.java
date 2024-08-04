package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddProductDAO{
	  static Connection con;
	    static {
	        try{
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","test");
	        }catch(Exception e){
	            System.out.println(e);
	        }

	    }
	    
	    private static int idCounter = 1;
	    public int generateUniqueId() {
	    	 return idCounter++;
	    }
	    
	    
	    public boolean addproductdata(AddProduct addpro) {
	    	boolean success=false;
	    	int category_id = addpro.getCategory_id();
	    	String name=addpro.getName();
	    	String description = addpro.getDescription();
	    	int price=addpro.getPrice();
	    	  int id = generateUniqueId(); 
	    	  try {
	              PreparedStatement pstmt = con.prepareStatement("INSERT INTO Products(id,category_id,name,description,price) VALUES (?,?, ?,?,?)");
	              pstmt.setInt(1, id);
	              pstmt.setInt(2, category_id);
	              pstmt.setString(3, name);
	              pstmt.setString(4, description);
	              pstmt.setInt(5, price);
	              int rowsAffected = pstmt.executeUpdate();

	              if (rowsAffected > 0) {
	                  System.out.println("User inserted successfully");
	                  success = true;
	              } else {
	                  System.out.println("Failed to insert user");
	              }
	          } catch (Exception e) {
	              System.out.println("Error inserting user: " + e.getMessage());
	          }
	    	return success;
	    }
}