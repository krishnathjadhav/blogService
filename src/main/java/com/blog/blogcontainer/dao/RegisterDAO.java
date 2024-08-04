package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RegisterDAO{
	static Connection con;
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","test");
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
    
    public int generateUniqueId() {
        return UUID.randomUUID().hashCode();
    }
    
    public boolean postRegister(Register res) {
        System.out.println("con: "+con);
    	boolean success=false;
    	String name=res.getName();
    	int mobile=res.getMobile();
    	String email=res.getEmail();
    	String role=res.getRole();
    	String password=res.getPassword();
         int id = generateUniqueId(); 
         try {
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO Register (id,name,mobile,email,role,password ) VALUES (?, ?, ?, ?, ?, ?)");
             pstmt.setInt(1, id);
             pstmt.setString(2, name);
             pstmt.setLong(3, mobile);
             pstmt.setString(4, email);
             pstmt.setString(5, role);
             pstmt.setString(6, password);
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