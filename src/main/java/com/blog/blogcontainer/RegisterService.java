package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.Cart;
import com.blog.blogcontainer.dao.Login;
import com.blog.blogcontainer.dao.LoginDAO;
import com.blog.blogcontainer.dao.Register;
import com.blog.blogcontainer.dao.RegisterDAO;
import com.blog.blogcontainer.dao.CartDAO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class RegisterService{
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/register")
	public  boolean postRegister(@RequestBody Register res) {
		System.out.println(res);
		return new RegisterDAO().postRegister(res);
	}
}