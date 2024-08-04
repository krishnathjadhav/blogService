package com.blog.blogcontainer.repositories;


import com.blog.blogcontainer.dao.Products;
import com.blog.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepository {
    static Connection con;
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","test");
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public User findUserByName(String name){
        User user = null; ;
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT password, role FROM register where name= ?");
            stmt.setString(1, name);
            //step4 execute query
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = new User(name, rs.getString(1), rs.getString(2));

            }
        }catch(Exception e) {
            e.printStackTrace();
        }


        return user;
    }
}
