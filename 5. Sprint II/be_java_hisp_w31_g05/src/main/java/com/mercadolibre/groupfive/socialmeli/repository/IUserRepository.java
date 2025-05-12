package com.mercadolibre.groupfive.socialmeli.repository;

import com.mercadolibre.groupfive.socialmeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    Optional<User> findById(Integer userId);
    void follow(Integer userId, Integer userIdToFollow);
    void unfollow(Integer userId, Integer userIdToUnfollow);
    List<User> findAll();
}
