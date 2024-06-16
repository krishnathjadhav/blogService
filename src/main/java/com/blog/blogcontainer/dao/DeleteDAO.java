package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDAO{
	  static Connection con;
	    static {
	        try{
	            //step1 load the driver class
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            //step2 create  the connection object
	            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","root123");

	            //step3 create the statement object


	            //step5 close the connection object
	            //con.close();

	        }catch(Exception e){
	        	
	            System.out.println(e);
	        }

	    }
	    
	    public boolean deleterow(int id) {
	    	boolean success=false;
	    	
	    	System.out.println(id);
	    	 try {
	    	        PreparedStatement pstmt = con.prepareStatement("DELETE FROM Cart WHERE id = ?");
	    	        pstmt.setInt(1, id);
	    	        int rowsAffected = pstmt.executeUpdate();

	    	        if (rowsAffected > 0) {
	    	            System.out.println("Cart deleted successfully");
	    	            success = true;
	    	        } else {
	    	            System.out.println("Failed to delete cart");
	    	        }
	    	    } catch (Exception e) {
	    	        System.out.println("Error deleting cart: " + e.getMessage());
	    	    }
	    	return success;
	    }
}