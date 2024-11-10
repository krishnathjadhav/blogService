package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.AddProduct;
import com.blog.blogcontainer.dao.AddProductDAO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

@RestController
@RequestMapping("/getTodos")
public class ToDos{
    @CrossOrigin(origins = "http://localhost:3000,http://localhost:3001")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String[] getTodos() {
        String[] todos = new String[]{"Learn React", "Learn Reduxx"};
        return todos;
    }
}