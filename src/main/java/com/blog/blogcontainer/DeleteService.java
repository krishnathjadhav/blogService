package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.BlogCategory;
import com.blog.blogcontainer.dao.BlogDAO;
import com.blog.blogcontainer.dao.Cart;
import com.blog.blogcontainer.dao.CartDAO;
import com.blog.blogcontainer.dao.Delete;
import com.blog.blogcontainer.dao.DeleteDAO;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class DeleteService {
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/delete/{id}")
	public boolean deleRow(@PathVariable int id) {
		return new DeleteDAO().deleterow(id);
	}
}