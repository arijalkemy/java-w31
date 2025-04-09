package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogPostDTO;
import com.mercadolibre.blog.model.BlogPost;
import com.mercadolibre.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/blog")
public class BlogPostController {
    @Autowired
    BlogPostService blogServ;

    @PostMapping
    public ResponseEntity<?> postBlog(@RequestBody BlogPostDTO blog) {
        blogServ.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body("Blog creado exitosamente");
    }

    @GetMapping("/{id}")
    public BlogPostDTO getBlogById(@PathVariable Integer id){
       return blogServ.getBlogById(id);
    }

    @GetMapping("/blogs")
    public HashMap<Integer, BlogPostDTO> getBlogs(){
        return blogServ.getListOfBlogs();
    }
}

