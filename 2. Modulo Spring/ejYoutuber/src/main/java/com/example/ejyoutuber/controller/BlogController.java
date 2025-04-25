package com.example.ejyoutuber.controller;

import com.example.ejyoutuber.dto.BlogDto;
import com.example.ejyoutuber.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    ResponseEntity<?> postNewBlog(@RequestBody BlogDto newBlog){
        return ResponseEntity.ok(blogService.addBlog(newBlog));
    }

    @GetMapping("/blog/{id}")
    ResponseEntity<?> getBlogById(@PathVariable String id){
        return ResponseEntity.ok(blogService.findBlogById(id));
    }

    @GetMapping("/blogs")
    @ResponseBody
    ResponseEntity<?> getBlogs(){
        return ResponseEntity.ok(blogService.findBlogs());
    }
}
