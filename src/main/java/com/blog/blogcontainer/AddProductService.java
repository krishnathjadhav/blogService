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
@RequestMapping("/addproduct")
public class AddProductService{
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "",method = RequestMethod.POST)
	public boolean addproduct(@RequestBody AddProduct addpro) {
		return new AddProductDAO().addproductdata(addpro);
	}
}