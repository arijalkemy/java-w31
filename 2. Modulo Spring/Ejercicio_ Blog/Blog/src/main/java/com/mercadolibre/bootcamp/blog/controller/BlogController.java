package com.mercadolibre.bootcamp.blog.controller;

import com.mercadolibre.bootcamp.blog.dto.BlogEntryDto;
import com.mercadolibre.bootcamp.blog.dto.ResponseDto;
import com.mercadolibre.bootcamp.blog.model.BlogEntry;
import com.mercadolibre.bootcamp.blog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final IBlogEntryService blogEntryService;

    @Autowired
    public BlogController(IBlogEntryService blogEntryService) {
        this.blogEntryService = blogEntryService;
    }

    @GetMapping()
    public ResponseEntity<List<BlogEntryDto>>  getAllBlogs() {
        List<BlogEntryDto> blogEntries = blogEntryService.getAllBlogs();
        return ResponseEntity.ok(blogEntries);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createBlog(@RequestBody BlogEntryDto blogEntryDto) {
        BlogEntryDto createdBlog = blogEntryService.createBlogEntry(blogEntryDto);
        ResponseDto responseDto = new ResponseDto(createdBlog.getId());
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogEntryDto> getBlog(@PathVariable Long id) {
        BlogEntryDto blogEntryDto = blogEntryService.getBlogEntryById(id);
        return new ResponseEntity<>(blogEntryDto, HttpStatus.OK);
    }


}
