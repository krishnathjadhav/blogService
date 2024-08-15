package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDAO{

	    
	    public boolean deleterow(int id) {
	    	boolean success=false;
			Connection con = DBUtil.getConnection();
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