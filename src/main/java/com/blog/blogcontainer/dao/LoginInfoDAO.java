package com.blog.blogcontainer.dao;

import com.blog.model.request.LoginReq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoginInfoDAO {
    static Connection con;
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","test");
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
//    public boolean postLogin(LoginInfo loginInfo) {
//    	boolean s=true;
//    	String username=loginInfo.getUsername();
//		String password =loginInfo.getPassword();
//    	System.out.println("Username is "+username+" "+password);
//    	return s;
//    }
    
    private static int idCounter = 4;
    public int generateUniqueId() {
    	 return idCounter++;
    }

  
    
    public Object postLogin(LoginReq loginInfo) {
        String role = null;
        int userId = -1;
        String username = loginInfo.getName();
        String password = loginInfo.getPassword();

        try {
            PreparedStatement pstmtSelectUser = con.prepareStatement("SELECT * FROM Register WHERE name = ? AND password = ?");
            pstmtSelectUser.setString(1, username);
            pstmtSelectUser.setString(2, password);
            ResultSet rsUser = pstmtSelectUser.executeQuery();

            if (rsUser.next()) {
            	userId = rsUser.getInt("id");
            	
                PreparedStatement pstmtSelectRole = con.prepareStatement("SELECT role FROM Register WHERE name = ?");
                pstmtSelectRole.setString(1, username);
                ResultSet rsRole = pstmtSelectRole.executeQuery();

                if (rsRole.next()) {
                    role = rsRole.getString("role");
                } 
            } else {
                System.out.println("User not found");
                /**int id = generateUniqueId();
                userId=id;
                PreparedStatement pstmtInsertUser = con.prepareStatement("INSERT INTO Users (id, name, password) VALUES (?, ?, ?)");
                pstmtInsertUser.setInt(1, id);
                pstmtInsertUser.setString(2, username);
                pstmtInsertUser.setString(3, password);
                int rowsAffected = pstmtInsertUser.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("New user inserted successfully");
                    PreparedStatement pstmtSelectRole = con.prepareStatement("SELECT role FROM Register WHERE name = ?");
                    pstmtSelectRole.setString(1, username);
                    ResultSet rsRole = pstmtSelectRole.executeQuery();

                    if (rsRole.next()) {
                        role = rsRole.getString("role");
                    } 
                } else {
                    System.out.println("Failed to insert new user");
                }**/
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error inserting/retrieving user: " + e.getMessage());
        }

        return new Object[] {role, userId};
    }


}