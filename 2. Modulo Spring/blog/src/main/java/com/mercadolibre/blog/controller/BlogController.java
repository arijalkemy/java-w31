package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> postNewBlog(@RequestBody BlogDTO blogDTO) {
        blogService.postNewBlog(blogDTO);
        return new ResponseEntity<>("Post " + blogDTO.getId() + " creado exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public BlogDTO getBlogById(@PathVariable Integer id) {
        return blogService.findById(id);
    }

    @GetMapping("/blogs")
    public HashMap<Integer, BlogDTO> getAllBlogs() {
        return blogService.findAll();
    }
}
