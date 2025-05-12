package com.mercadolibre.groupfive.socialmeli.service;

import com.mercadolibre.groupfive.socialmeli.dto.UserDto;
import com.mercadolibre.groupfive.socialmeli.model.User;

import java.util.List;

public interface IUserService {

    User findById(Integer userId);

    UserDto countFollowers(int userId);
  
    UserDto getFollowers(int userId, String order);

    UserDto getFollowed(int userId, String order);

    UserDto getAmountPromosBySeller(Integer userId);

    void follow (Integer userId, Integer userIdToFollow);
    
    void unfollow (Integer userId, Integer userIdToUnfFollow);

    UserDto findPostByFollowedUser(Integer userId, String order);

    List<UserDto> getUserWithMoreFollowers();

    void followManyUsers(Integer userId, List<Integer> userIdsToFollow);

    void unFollowManyUsers(UserDto users, Integer userId);
}
