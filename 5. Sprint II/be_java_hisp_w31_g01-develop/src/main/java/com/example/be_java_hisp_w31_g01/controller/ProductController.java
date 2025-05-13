package com.example.be_java_hisp_w31_g01.controller;

import com.example.be_java_hisp_w31_g01.dto.PostPromoDto;
import com.example.be_java_hisp_w31_g01.dto.PostRequestDto;
import com.example.be_java_hisp_w31_g01.dto.PostResponseWrapperDto;
import com.example.be_java_hisp_w31_g01.service.IPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private IPostService postService;

    //US0005
    @PostMapping("/products/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostRequestDto postRequestDto) {
        postService.createPost(postRequestDto);
        return new ResponseEntity<>("Publicación creada con éxito",HttpStatus.OK);
    }

    // US0006
    // US0009
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable int userId, @RequestParam (required = false) String order) {
        PostResponseWrapperDto response = postService.getFollowedSellerPostsInLastTwoWeeks(userId, order);
        return ResponseEntity.ok(response);
    }

    //US0010
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> newProductPromo(@Valid @RequestBody PostPromoDto postPromoDto){
        postService.newPostPromo(postPromoDto);
        return new ResponseEntity<>("Publicación creada con éxito",HttpStatus.OK);
    }

    //US0011
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostCount(user_id), HttpStatus.OK);
    }

    //US0012
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPromoPostList(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostList(user_id), HttpStatus.OK);
    }

    //US0013
    @DeleteMapping("/products/post/{userId}/{post_id}")
    public ResponseEntity<?> deletePost(@PathVariable int userId, @PathVariable int post_id) {
        postService.deletePost(userId, post_id);
        return new ResponseEntity<>("Se eliminó correctamente la publicación con ID " + post_id + " del usuario " + userId+ ".",HttpStatus.OK);
    }
}