package com.mercadolibre.be_java_hisp_w31_g02.service;

import com.mercadolibre.be_java_hisp_w31_g02.dto.DeleteUserDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.UserFollowersDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.SubscriptionDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.UsersFollowedDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.FollowerCountDto;

public interface IUserService {
    UsersFollowedDto getAllUsersFollowedByAnUser(Integer userId, String order);
    SubscriptionDto subscribeUserToUser(Integer userId, Integer userIdToFollow);
    FollowerCountDto getFollowersCountById(Integer userId);
    UserFollowersDto getAllFollowersOfASeller(Integer userId, String order);
    DeleteUserDto unfollowUser(Integer userId, Integer unfollowSellerId);
}
