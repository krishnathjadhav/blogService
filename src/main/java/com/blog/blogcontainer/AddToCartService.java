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

import com.blog.blogcontainer.dao.AddToCart;
import com.blog.blogcontainer.dao.AddToCartDAO;


@RestController
public class AddToCartService{
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addtocart")
	public boolean addtocart(@RequestBody AddToCart add) {
		
		return new AddToCartDAO().addtocart(add);
	}
}