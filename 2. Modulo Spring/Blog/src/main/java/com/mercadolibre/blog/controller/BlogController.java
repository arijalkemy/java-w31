package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.EntryBlogDto;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final IBlogService blogService;

    @Autowired
    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<EntryBlogDto> createBlog(@RequestBody EntryBlogDto entryBlogDto) {
        EntryBlogDto createdBlog = blogService.createBlog(entryBlogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntryBlogDto> getBlogById(@PathVariable Integer id) {
        try {
            EntryBlogDto blog = blogService.getBlogById(id);
            return ResponseEntity.ok(blog);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new EntryBlogDto(-1, "Blog Not Found", "The blog with the given ID does not exist.", ""));
        }
    }


    @GetMapping
    public ResponseEntity<List<EntryBlogDto>> getAllBlogs() {
        List<EntryBlogDto> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }
}
