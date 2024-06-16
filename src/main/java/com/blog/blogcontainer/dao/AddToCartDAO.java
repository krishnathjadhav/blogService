package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class AddToCartDAO {
    static Connection con;
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","root123");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private static int idCounter = 1;
    public int generateUniqueId() {
    	 return idCounter++;
    }
    
    
    public boolean addtocart(AddToCart add) {
    	boolean success=false;
    	System.out.println("id is"+add.getUser_id()+"product is"+add.getProducts()+" amount "+add.getBilling_amount());
    	  int id = generateUniqueId(); 
    	 int user_id=add.getUser_id();
    	String products=add.getProducts();
     int noOfItems=add.getNoOfItems();
     int billing_amount=add.getBilling_amount();
    	
     try {
    	  PreparedStatement pstmtSelectUser = con.prepareStatement("SELECT * FROM Users WHERE id = ?");
          pstmtSelectUser.setInt(1, user_id);
          ResultSet rsUser = pstmtSelectUser.executeQuery();
          
          if (rsUser.next()) {
         PreparedStatement pstmt = con.prepareStatement("INSERT INTO CART (id,user_id,products,noOfItems,billing_amount) VALUES  (?,?, ?,?,?)");
         pstmt.setInt(1, id);
         pstmt.setInt(2, user_id);
         pstmt.setString(3, products);
         pstmt.setInt(4, noOfItems);
         pstmt.setInt(5, billing_amount);
         int rowsAffected = pstmt.executeUpdate();

         if (rowsAffected > 0) {
             System.out.println("User inserted successfully");
             success = true;
         } else {
             System.out.println("Failed to insert user");
         }
          } else {
              System.out.println("User with id " + user_id + " does not exist");
          }
     } catch (Exception e) {
         System.out.println("Error inserting user: " + e.getMessage());
     }
    	
    	return success;
    }
        

    }
    