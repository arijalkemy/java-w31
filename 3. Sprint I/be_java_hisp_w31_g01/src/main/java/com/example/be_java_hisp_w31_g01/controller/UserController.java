package com.example.be_java_hisp_w31_g01.controller;

import com.example.be_java_hisp_w31_g01.dto.SellerDto;
import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {this.userService = userService;}

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>("Vendedor seguido con éxito",HttpStatus.OK);
    }

    //US0003-List_followers
    //US0008-Order_by_name
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> followers(@PathVariable int userId, @RequestParam (required = false) String order){
        return new ResponseEntity<>(userService.getFollowers(userId,order), HttpStatus.OK);
    }

    //US0004-List_followed
    //US0008-Order_by_name
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> followed(@PathVariable int userId, @RequestParam (required = false) String order){
        return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }

    //US0007
    @PutMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        userService.unfollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>("Se ha dejado de seguir al vendedor con éxito",HttpStatus.OK);
    }
    //US0002
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<?> countFollowers(@PathVariable int userId){
        long count = userService.countFollowers(userId);
        String userName = userService.userNameSeller(userId);
        SellerDto dto = new SellerDto(userId, userName ,count);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
