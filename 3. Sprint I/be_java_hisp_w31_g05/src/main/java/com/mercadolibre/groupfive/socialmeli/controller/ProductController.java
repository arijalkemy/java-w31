package com.mercadolibre.groupfive.socialmeli.controller;

import org.springframework.web.bind.annotation.*;
import com.mercadolibre.groupfive.socialmeli.dto.PostDto;
import com.mercadolibre.groupfive.socialmeli.dto.UserDto;
import com.mercadolibre.groupfive.socialmeli.service.IPostService;
import com.mercadolibre.groupfive.socialmeli.service.IUserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IPostService postService;
    private final IUserService userService;

    public ProductController(IPostService postService, IUserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/promo-post")
    public ResponseEntity<Void> postNewPromo(@RequestBody PostDto postDto) {
        postService.createPromoPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/promo-post/count", params = { "user_id" })
    public UserDto getAmountPromosBySeller(@RequestParam("user_id") Integer userId) {
        return userService.getAmountPromosBySeller(userId);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<UserDto> findPostsByFollowedUser(
            @PathVariable("user_id") Integer userId,
            @RequestParam(required = false, defaultValue = "date_desc") String order) {
        return new ResponseEntity<>(userService.findPostByFollowedUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Void> createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts-by-brand/{brand}")
    public ResponseEntity<List<PostDto>> getPostsByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(postService.findPostsByBrand(brand));
    }

    @GetMapping("/posts-by-price")
    public ResponseEntity<List<PostDto>> findProductsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok().body(postService.findAllByPriceRange(min, max));
    }

}
