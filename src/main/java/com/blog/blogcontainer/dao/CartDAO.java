package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    public  List<Cart> getCarts() {
        List<Cart> carts = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        try {
            Statement stmt = con.createStatement();

            //step4 execute query
            ResultSet rs = stmt.executeQuery("SELECT c.id,u.name,c.products , c.billing_amount FROM Cart c, Users u WHERE c.user_id=u.id");
            System.out.println("see resultSet: "+ rs);
            while (rs.next()) {
                System.out.println("See ammount: "+rs.getInt(4));
                System.out.println(rs);
                carts.add( new Cart(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4)));

            }

        }catch(Exception e) {

        }
        return carts;
    }
}
