package org.example.blog.controllers;

import org.example.blog.DTO.EntradaBlogDTO;
import org.example.blog.entities.EntradaBlog;
import org.example.blog.services.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    BlogService serviceBlog;

    public BlogController(BlogService serviceBlog) {
        this.serviceBlog = serviceBlog;
    }

    @PostMapping("/blog")
    public String crearBlog (@RequestBody EntradaBlogDTO entradaBlog) {
        serviceBlog.createBlog(entradaBlog);
        return "Se ha creado su blog con id: "+entradaBlog.getId();
    }

    @GetMapping("/blog/{id}")
    public EntradaBlogDTO getBlogById(@PathVariable int id) {
        return serviceBlog.getBlogById(id);
    }

    @GetMapping("/blogs")
    public List<EntradaBlogDTO> getBlogs() {
        return serviceBlog.getAllBlogs();
    }
}
