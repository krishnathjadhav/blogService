package com.blog.blogcontainer;

import com.blog.blogcontainer.dao.BlogCategory;
import com.blog.blogcontainer.dao.BlogDAO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
@RequestMapping("/getBlogCategories")
public class BlogService {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<BlogCategory> getBlogCategories() {
        return new BlogDAO().getBlogCatogories();
    }
}
