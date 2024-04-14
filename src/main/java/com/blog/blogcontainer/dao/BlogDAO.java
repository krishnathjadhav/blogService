package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {
    static Connection con;
    static {
        try{
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","test");

            //step3 create the statement object


            //step5 close the connection object
             //con.close();

            }catch(Exception e){
                System.out.println(e);
            }

    }
    public List<BlogCategory> getBlogCatogories() {
        List<BlogCategory> blogCategories = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();

            //step4 execute query
            ResultSet rs = stmt.executeQuery("select * from BLOG_CATEGORY");

            while (rs.next()) {
                BlogCategory bc = new BlogCategory(rs.getInt(1), rs.getString(2),rs.getString(3));
                blogCategories.add(bc);
            }

        }catch(Exception e) {

        }
        return blogCategories;
    }


}


