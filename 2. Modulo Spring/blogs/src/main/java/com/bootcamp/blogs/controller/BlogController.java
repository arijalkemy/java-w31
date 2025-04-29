package com.bootcamp.blogs.controller;

import com.bootcamp.blogs.dto.BlogDto;
import com.bootcamp.blogs.dto.BlogDtoRequest;
import com.bootcamp.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;
    @PostMapping("/blog")
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDtoRequest req) throws Exception {
        return new ResponseEntity<>(blogService.create(req), HttpStatus.OK);
    }
}
