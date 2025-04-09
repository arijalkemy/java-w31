package org.mercadolibre.ejercicio_blog.controller;

import org.mercadolibre.ejercicio_blog.dto.EntradaBlogDTO;
import org.mercadolibre.ejercicio_blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<?> createNewBlog(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        return new ResponseEntity<>(blogService.addBlog(entradaBlogDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id) {
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }
}
