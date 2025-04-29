package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.mercadolibre.be_java_hisp_w31_g02.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> findUserById(Integer userId);
    Boolean existUser(Integer client);
    void addPublicationToUser (User seller, Integer publicationId);
    List<User> findUsers(List<Integer> followedBy);
}
