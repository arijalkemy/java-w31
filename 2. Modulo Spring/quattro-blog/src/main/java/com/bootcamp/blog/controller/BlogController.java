package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogEntryDto;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog/")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<BlogEntryDto>> getBlogEntries() {
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogEntryDto> getBlogById(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BlogEntryDto> createBlogEntry(@RequestBody BlogEntryDto blogEntryDto) {
        return new ResponseEntity<>(blogService.addEntry(blogEntryDto), HttpStatus.CREATED);
    }

}
