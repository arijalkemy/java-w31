package com.blog.blog.controller;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.repository.BlogRepositoryImpl;
import com.blog.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> addBlog(@RequestBody EntradaBlogDTO e){
        return blogService.addEntrdaBlog(e);
    }

    @GetMapping("/blog/{id}")
    public EntradaBlogDTO getBlogId(@PathVariable Integer id) {
        return blogService.getEntradaBlog(id);
    }

    @GetMapping("blogs")
    public List<EntradaBlogDTO> getListBlog() {
        return blogService.getAllEntradaBlog();
    }
}
