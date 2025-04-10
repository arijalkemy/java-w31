package com.blog.blog.controller;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.repository.BlogRepositoryImpl;
import com.blog.blog.repository.IBlogRepository;
import com.blog.blog.service.BlogServiceImpl;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> addBlog(@RequestBody EntradaBlogDTO e){
        return blogService.add(e);
    }

    @GetMapping("/blog/{id}")
    public EntradaBlogDTO getBlogId(@PathVariable Integer id) {
        return blogService.findById(id);
    }

    @GetMapping("blogs")
    public List<EntradaBlogDTO> getListBlog() {
        return blogService.getAll();
    }
}
