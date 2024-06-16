package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartListDAO{
	static Connection con;
    static {
    	
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","root123");
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
    public List<CartList> getCarts(int userId) {
        List<CartList> carts = new ArrayList<>();
        try {
            String query = "SELECT * FROM Cart WHERE user_id=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                carts.add(new CartList(rs.getInt("id"), rs.getInt("user_id"), rs.getString("products"), rs.getInt("noOfItems"), rs.getInt("billing_amount")));
            }

            pstmt.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return carts;
    }
    
   
}