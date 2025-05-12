package com.mercadolibre.groupfive.socialmeli.util;

import com.mercadolibre.groupfive.socialmeli.model.User;

import java.util.ArrayList;
import java.util.List;

public class TestDataFactory {

    public static User validUser(Integer userId, String name, List<Integer> followers, List<Integer> followeds) {
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setFollowers(new ArrayList<>(followers));
        user.setFolloweds(new ArrayList<>(followeds));
        return user;
    }
}
