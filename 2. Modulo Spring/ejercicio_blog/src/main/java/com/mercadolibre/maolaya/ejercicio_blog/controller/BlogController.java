package com.mercadolibre.maolaya.ejercicio_blog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.maolaya.ejercicio_blog.dto.BlogEntryDto;
import com.mercadolibre.maolaya.ejercicio_blog.service.BlogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/blog")
    public String postNewBlog(@RequestBody BlogEntryDto blogEntryDto) {
        return blogService.createNewBlog(blogEntryDto);
    }

    @GetMapping("/blog/{id}")
    public BlogEntryDto getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id);
    }

    @GetMapping("/blogs")
    public List<BlogEntryDto> getAllBlogs() {
        return blogService.getAllBlogs();
    }

}
