package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody EntradaBlogDto eBlogDto){
        blogService.createBlog(eBlogDto);
        return new ResponseEntity<>("Blog creado con exito", HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getByID(@PathVariable Integer id){
        return  new ResponseEntity<>(blogService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAll(){
        return  new ResponseEntity<>(blogService.getAllDto(),HttpStatus.OK);
    }

}
