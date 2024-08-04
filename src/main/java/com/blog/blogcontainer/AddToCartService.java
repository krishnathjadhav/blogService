package com.blog.blogcontainer;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.blog.blogcontainer.dao.AddToCart;
import com.blog.blogcontainer.dao.AddToCartDAO;


@RestController
@RequestMapping("/addtocart")
public class AddToCartService{
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "",method = RequestMethod.POST)
	public boolean addtocart(@RequestBody AddToCart add) {
		
		return new AddToCartDAO().addtocart(add);
	}
}