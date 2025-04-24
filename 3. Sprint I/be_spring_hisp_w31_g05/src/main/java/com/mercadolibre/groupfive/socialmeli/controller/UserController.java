package com.mercadolibre.groupfive.socialmeli.controller;

import com.mercadolibre.groupfive.socialmeli.dto.UserDto;
import com.mercadolibre.groupfive.socialmeli.service.IUserService;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<UserDto> countFollowers(@PathVariable Integer userId) {

        return ResponseEntity.ok(userService.countFollowers(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDto> getFollowers(@PathVariable Integer userId,
            @RequestParam(value = "order", required = false) String order) {
        return ResponseEntity.ok(userService.getFollowers(userId, order));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDto> getFollowed(@PathVariable Integer userId,
            @RequestParam(value = "order", required = false) String order) {
        return ResponseEntity.ok(userService.getFollowed(userId, order));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        this.userService.follow(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        this.userService.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/most-popular")
    public ResponseEntity<List<UserDto>> getUserWithMoreFollowers() {
        return ResponseEntity.ok(userService.getUserWithMoreFollowers());
    }


    @PutMapping("/{userId}/follow")
    public ResponseEntity<String> putFollowManyUsers(@PathVariable Integer userId,
            @RequestBody List<Integer> userIdsToFollow) {
        userService.followManyUsers(userId, userIdsToFollow);
        return new ResponseEntity<>("Usuarios seguidos exitosamente", HttpStatus.OK);
    }

    @PutMapping("/{userId}/unfollow")
    public ResponseEntity<Void> unFollowManyUsers(@RequestBody UserDto followeds, @PathVariable Integer userId){
        this.userService.unFollowManyUsers(followeds, userId);
        return ResponseEntity.ok().build();
    }
}
