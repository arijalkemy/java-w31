package org.ejercicios.ytblog.controller;

import org.ejercicios.ytblog.dto.BlogDTO;
import org.ejercicios.ytblog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<Integer> addNewBlog(@RequestBody BlogDTO dto) {
        return ResponseEntity.ok(service.addBlog(dto));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        return ResponseEntity.ok(service.getAllBlogs());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable int id) {
        return ResponseEntity.ok(service.getBlog(id));
    }

}
