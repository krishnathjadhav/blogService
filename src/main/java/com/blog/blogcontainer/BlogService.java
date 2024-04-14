package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.BlogCategory;
import com.blog.blogcontainer.dao.BlogDAO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class BlogService {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getBlogCategories")
    public List<BlogCategory> getBlogCategories() {
        return new BlogDAO().getBlogCatogories();
    }
}
