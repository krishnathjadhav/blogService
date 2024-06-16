package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO{
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
	    public  List<Products> getProducts() {
	        List<Products> products = new ArrayList<>();
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