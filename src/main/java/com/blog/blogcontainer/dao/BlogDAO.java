package com.blog.blogcontainer.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {

    public List<BlogCategory> getBlogCatogories() {
        Connection con = DBUtil.getConnection();
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


