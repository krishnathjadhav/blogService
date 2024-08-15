package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO{

	    public  List<Products> getProducts() {
	        List<Products> products = new ArrayList<>();
			Connection con = DBUtil.getConnection();
	        try {
	            Statement stmt = con.createStatement();

	            //step4 execute query
	            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
	          
	            while (rs.next()) {
	                products.add( new Products(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4), rs.getInt(5)));
//	                id,category_id,name,description,price
	            }

	        }catch(Exception e) {

	        }
	        return products;
	    }
}