package com.example.Blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.Blog.DTO.BlogEntryDTO;
import com.example.Blog.Entities.BlogEntry;
import com.example.Blog.Service.BlogServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BlogController {
    @Autowired
    BlogServiceImpl service;

    @PostMapping("/blog")
    public ResponseEntity<String> postBlogEntry(@RequestBody BlogEntry blogEntry) {
        return service.newEntry(blogEntry);
    }

    @GetMapping("/blog/{id}")
    public BlogEntryDTO getBlogEntry(@PathVariable String id) {
        return service.getEntry(id);
    }

    @GetMapping("/blogs")
    public List<BlogEntryDTO> getAll() {
        return service.getAll();
    }
}
