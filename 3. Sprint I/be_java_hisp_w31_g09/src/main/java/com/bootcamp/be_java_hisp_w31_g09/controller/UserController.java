package com.bootcamp.be_java_hisp_w31_g09.controller;

import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseFollowersCountDTO;
import com.bootcamp.be_java_hisp_w31_g09.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getSellerFollowers(@PathVariable Integer userId,
                                                @RequestParam(required = false) Optional<String> order) {
        return ResponseEntity.ok(userService.getSellerFollowersOrdered(userId, order));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")

    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }

    @PutMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollow(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followed/list")
    ResponseEntity<?> getSellersFollowed(@PathVariable Integer userId,
                                         @RequestParam(required = false) Optional<String> order){
        return ResponseEntity.ok(userService.searchSellersFollowedOrdered(userId, order));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<ResponseFollowersCountDTO> getFollowersCount(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getFollowersCount(userId));
    }

    @GetMapping("/followers/seller/ranking")
    public ResponseEntity<?> getRankingFollowersSeller(@RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.getRankingFollowersSeller(order));
    }

}
