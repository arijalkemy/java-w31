package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.mercadolibre.be_java_hisp_w31_g02.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionRepository {
    List<Subscription> getAllUsersFollowedByAnUser(Integer userId);
    void addUserFollowedByAnUser(Subscription Subscription);
    Boolean existRelationBetweenUsers(Integer userId, Integer userIdToFollow);
    List<Subscription> listFollowerById(Integer sellerId);
    Optional<Subscription> findFollowerById(Integer userId, Integer unfollowerSellerId);
    void deleteFollower(Subscription Subscription);
    List<Subscription> getAllFollowersOfASeller(Integer userId);
    List<Subscription> getFollowedSeller(Integer userId);
}
