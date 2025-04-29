package com.mercadolibre.be_java_hisp_w31_g02.controller;

import com.mercadolibre.be_java_hisp_w31_g02.dto.*;
import com.mercadolibre.be_java_hisp_w31_g02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UsersFollowedDto> getAllUsersFollowedByAnUser(
            @PathVariable("userId") Integer userId,
            @RequestParam(name = "order", required = false, defaultValue="") String order
        ){
        return new ResponseEntity<>(userService.getAllUsersFollowedByAnUser(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDto> getFollowersCount (@PathVariable("userId") Integer sellerId) {
        return new ResponseEntity<>(userService.getFollowersCountById(sellerId), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<SubscriptionDto> subscribeUserToUser(
            @PathVariable Integer userId,
            @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(userService.subscribeUserToUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersDto> getFollowers(
        @PathVariable Integer userId,
        @RequestParam(name = "order", required = false, defaultValue="") String order
    ) {
        UserFollowersDto response = userService.getAllFollowersOfASeller(userId, order);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<DeleteUserDto> unfollowUser(@PathVariable("userId") Integer userId,
                                                      @PathVariable("userIdToUnfollow") Integer unfollowSellerId){
        return new ResponseEntity<>(userService.unfollowUser(userId,unfollowSellerId),HttpStatus.OK);

    }
}

