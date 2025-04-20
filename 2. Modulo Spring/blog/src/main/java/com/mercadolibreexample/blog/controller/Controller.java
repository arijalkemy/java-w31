package com.mercadolibreexample.blog.controller;

import com.mercadolibreexample.blog.dto.EntradaBlogDto;
import com.mercadolibreexample.blog.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @PostMapping("/blog")
    public ResponseEntity<String> createBlog(@RequestBody EntradaBlogDto entradaBlogDto) throws Exception {
        String message = service.createBlog(entradaBlogDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getBlog(@PathVariable int id) {
        return new ResponseEntity<>(service.getBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogs() {
        return new ResponseEntity<>(service.getAllBlogs(), HttpStatus.OK);
    }
}
