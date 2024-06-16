package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.AddProduct;
import com.blog.blogcontainer.dao.AddProductDAO;
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
import java.util.List;

@RestController
public class AddProductService{
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addproduct")
	public boolean addproduct(@RequestBody AddProduct addpro) {
		return new AddProductDAO().addproductdata(addpro);
	}
}