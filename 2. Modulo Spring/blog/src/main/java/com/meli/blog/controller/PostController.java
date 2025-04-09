package com.meli.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.blog.dto.CreatePostRequestDTO;
import com.meli.blog.dto.GetPostResponseDTO;
import com.meli.blog.service.PostService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/blog")
    public ResponseEntity<String> createPost(@RequestBody CreatePostRequestDTO body) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postService.createPost(body));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<GetPostResponseDTO> getPostById(@PathVariable String id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<GetPostResponseDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

}
