package com.bootcamp.be_java_hisp_w31_g09.controller;

import com.bootcamp.be_java_hisp_w31_g09.dto.*;
import com.bootcamp.be_java_hisp_w31_g09.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //US-0005
    @PostMapping("/post")
    public ResponseEntity<ResponseMessageDTO> post(@Valid @RequestBody RequestPostDTO requestPostDTO) {
        return ResponseEntity.ok(productService.savePost(requestPostDTO));
    }
    @PostMapping("/promo-post")
    public ResponseEntity<ResponseMessageDTO> promoPost(@Valid @RequestBody RequestPromoPostDTO requestPromoPostDTO) {
        return ResponseEntity.ok(productService.savePromoPost(requestPromoPostDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostsResponseDTO> getFollowedPosts(@PathVariable int userId,
                                              @RequestParam(required = false)  String order){
        return ResponseEntity.ok(productService.getFollowedPostsOrder(userId,order));
    }

    @GetMapping("/post/list")
    public ResponseEntity<UserPostsResponseDTO> getPostsByUser(@RequestParam Integer user_id){
        return ResponseEntity.ok(productService.getPostsByUser(user_id));
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<ResponsePromoPostDTO> getPromoPostsByUser(@RequestParam Integer user_id){
        return ResponseEntity.ok(productService.getPromoPostsByUser(user_id));
    }
  
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountResponseDTO> getPromoProductsCount(@RequestParam("user_id") Integer userId) {
        return ResponseEntity.ok(productService.getPromoProductsCount(userId));
    }

    @PutMapping("/discount/by-post/{postId}/by-seller/{sellerId}")
    public ResponseEntity<ResponseMessageDTO> putDiscountByPostId(@PathVariable Integer postId,
                                                                  @PathVariable Integer sellerId,
                                                                  @RequestBody @Valid DiscountDTO discount){
        return ResponseEntity.ok(productService.updateDiscountByPostId(postId, sellerId, discount));
    }

    @PutMapping("/discount/by-seller/{sellerId}")
    public ResponseEntity<ResponseMessageDTO> updateDiscountsBySeller(@PathVariable Integer sellerId,
                                                                      @RequestBody @Valid DiscountDTO discount) {
        return ResponseEntity.ok(productService.updateDiscountsBySeller(sellerId, discount.getDiscount()));
    }

    @PutMapping("/seller/{userId}/prices")
    public ResponseEntity<ResponseMessageDTO> updatePrices(@PathVariable Integer userId,
                                                           @RequestBody @Valid UpdatePricesDTO  updatePricesDTO) {
        return ResponseEntity.ok(productService.updateUserPrices(userId, updatePricesDTO));
    }
    @GetMapping("/{userId}/posts/price-range")
    public ResponseEntity<List<PromoPostDTO>> getPostsByPriceRange(@PathVariable Integer userId,
                                                              @RequestParam Double minPrice,
                                                              @RequestParam Double maxPrice) {
        return ResponseEntity.ok(productService.getPostsByPriceRange(userId, minPrice, maxPrice));
    }

}
