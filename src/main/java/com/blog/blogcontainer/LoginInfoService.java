package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.BlogCategory;
import com.blog.blogcontainer.dao.BlogDAO;
import com.blog.blogcontainer.dao.Cart;
import com.blog.blogcontainer.dao.CartDAO;
import com.blog.blogcontainer.dao.LoginInfo;
import com.blog.blogcontainer.dao.LoginInfoDAO;

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
public class LoginInfoService {
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/Login")
	public Object postLogin(@RequestBody LoginInfo loginInfo) {
		
		return new LoginInfoDAO().postLogin(loginInfo);
	}
}


//[]