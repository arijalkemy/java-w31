package com.bootcamp.ejercicio_excepciones.controller;

import com.bootcamp.ejercicio_excepciones.dto.InputBlogDto;
import com.bootcamp.ejercicio_excepciones.service.IInputBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InputBlogController {
    @Autowired
    private IInputBlogService inputBlogService;

    @PostMapping("/blog")
    public ResponseEntity<Integer> saveInputBlog(@RequestBody InputBlogDto inputBlogDto) {
        return ResponseEntity.ok(inputBlogService.saveInputBlog(inputBlogDto));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<InputBlogDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(inputBlogService.findById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<InputBlogDto>> findAll() {
        return ResponseEntity.ok(inputBlogService.findAll());
    }
}
