package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.EntradaBlogDto;
import com.mercadolibre.blog.service.BlogService;
import com.mercadolibre.blog.service.BlogServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    BlogService blogService = new BlogServiceImpl();

    @PostMapping("/blog")
    public EntradaBlogDto createBlog(@RequestBody EntradaBlogDto blog) {
        return blogService.createBlog(blog);
    }

    @GetMapping("/blog/{id}")
    public EntradaBlogDto getBlog(@PathVariable String id) {
        return blogService.findById(id);
    }

    @GetMapping("/blogs")
    public List<EntradaBlogDto> getAllBlogs() {
        return blogService.findAll();
    }
}
