package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO{

    public  List<Login> getLogin() {
        List<Login> loginInfo = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        try {
            Statement stmt = con.createStatement();

            //step4 execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
         
            while (rs.next()) {
            	System.out.print(rs.getInt(1));
            	loginInfo.add( new Login(rs.getInt(1), rs.getString(2),rs.getString(3)));

            }

        }catch(Exception e) {

        }
        return loginInfo;
    }
    
    
  
    
}