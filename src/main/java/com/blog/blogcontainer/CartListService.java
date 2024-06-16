package com.blog.blogcontainer;

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

import com.blog.blogcontainer.dao.Cart;
import com.blog.blogcontainer.dao.CartList;
import com.blog.blogcontainer.dao.CartListDAO;

import java.util.List;

@RestController
public class CartListService{
	@CrossOrigin(origins = "http://localhost:3000")
	  @GetMapping("/carts/{userId}")
	public List<CartList> getCarts(@PathVariable int userId) {
		System.out.println(userId);
		 return new CartListDAO().getCarts(userId);
    }
}