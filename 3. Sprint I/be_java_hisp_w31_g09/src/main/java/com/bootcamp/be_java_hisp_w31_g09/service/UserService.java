package com.bootcamp.be_java_hisp_w31_g09.service;

import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseMessageDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.UserListDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseFollowersCountDTO;


import java.util.List;

import java.util.Optional;


public interface UserService {
    UserListDTO getSellerFollowers(Integer userId);
    ResponseMessageDTO follow(Integer userId, Integer userIdToFollow);
    UserListDTO searchSellersFollowed(Integer userId);
    ResponseMessageDTO unfollow(Integer userId, Integer userIdToUnfollow);
    ResponseFollowersCountDTO getFollowersCount(Integer userId);
    UserListDTO getSellerFollowersOrdered(Integer userId, Optional<String> order);
    UserListDTO searchSellersFollowedOrdered(Integer userId, Optional<String> order);
    List<ResponseFollowersCountDTO> getRankingFollowersSeller(String order);

}
