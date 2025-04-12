package com.mercadolibre.consigna.controller;

import com.mercadolibre.consigna.exception.BlogNotFoundException;
import com.mercadolibre.consigna.exception.DuplicateBlogIdException;
import com.mercadolibre.consigna.model.EntradaBlog;
import com.mercadolibre.consigna.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> createBlog(@RequestBody EntradaBlog blog) {
        try {
            blogService.createBlog(blog);
            return ResponseEntity.ok("Blog creado correctamente con ID: " + blog.getId());
        } catch (DuplicateBlogIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id) {
        try {
            EntradaBlog blog = blogService.getBlogById(id);
            return ResponseEntity.ok(blog);
        } catch (BlogNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlog>> getAllBlogs() {
        List<EntradaBlog> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }
}
