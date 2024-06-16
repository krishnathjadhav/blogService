package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.Cart;
import com.blog.blogcontainer.dao.Login;
import com.blog.blogcontainer.dao.LoginDAO;
import com.blog.blogcontainer.dao.CartDAO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class LoginService {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getLogin")
    public List<Login> getLogin() {
    	System.out.println("Login service called");
        return new LoginDAO().getLogin();
    }
}
