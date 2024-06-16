package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.BlogCategory;
import com.blog.blogcontainer.dao.BlogDAO;
import com.blog.blogcontainer.dao.Cart;
import com.blog.blogcontainer.dao.CartDAO;
import com.blog.blogcontainer.dao.Products;
import com.blog.blogcontainer.dao.ProductsDAO;

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
public class ProductsService{
	@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getproducts")
    public List<Products> getProducts() {
        return new ProductsDAO().getProducts();
    }
}