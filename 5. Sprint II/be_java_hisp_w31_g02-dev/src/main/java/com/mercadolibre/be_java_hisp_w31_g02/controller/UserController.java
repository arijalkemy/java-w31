package com.mercadolibre.be_java_hisp_w31_g02.controller;

import com.mercadolibre.be_java_hisp_w31_g02.dto.*;
import com.mercadolibre.be_java_hisp_w31_g02.service.IUserService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UsersFollowedDto> getAllUsersFollowedByAnUser(

            @PathVariable("userId")
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.") Integer userId,
            @RequestParam(name = "order", required = false, defaultValue="name_asc") String order
        ){
        return new ResponseEntity<>(userService.getAllUsersFollowedByAnUser(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDto> getFollowersCount (
        @PathVariable("userId")
        @Positive(message = "El id debe ser mayor a cero.")
        @NotNull(message = "El  id no puede estar vacío.") Integer sellerId
    ) {
        return new ResponseEntity<>(userService.getFollowersCountById(sellerId), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<SubscriptionDto> subscribeUserToUser(
            @PathVariable("userId")
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.") Integer userId,
            @PathVariable("userIdToFollow")
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.") Integer userIdToFollow){
        return new ResponseEntity<>(userService.subscribeUserToUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersDto> getFollowers(
        @PathVariable
        @Positive(message = "El id debe ser mayor a cero.")
        @NotNull(message = "El  id no puede estar vacío.") Integer userId,
        @RequestParam(name = "order", required = false, defaultValue="name_asc") String order
    ) {
        UserFollowersDto response = userService.getAllFollowersOfASeller(userId, order);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<DeleteUserDto> unfollowUser(
            @PathVariable("userId")
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.") Integer userId,
            @PathVariable("userIdToUnfollow")
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.") Integer unfollowSellerId
        ){
        return new ResponseEntity<>(userService.unfollowUser(userId,unfollowSellerId),HttpStatus.OK);

    }
}

