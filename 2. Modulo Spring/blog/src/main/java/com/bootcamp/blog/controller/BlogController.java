package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> postBlog(@RequestBody BlogDTO blogDTO) {
        blogService.saveBlog(blogDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Se guardo el blog con el id: " + blogDTO.getId());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlogByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getBlog(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
      return ResponseEntity.status(HttpStatus.OK).body(blogService.getAllBlogs());
    }
}
