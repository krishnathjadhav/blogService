package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartListDAO{

    
    public List<CartList> getCarts(int userId) {
        List<CartList> carts = new ArrayList<>();
        Connection con = DBUtil.getConnection();
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