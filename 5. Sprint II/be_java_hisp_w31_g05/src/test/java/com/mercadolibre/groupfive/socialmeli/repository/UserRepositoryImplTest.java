package com.mercadolibre.groupfive.socialmeli.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImpl userRepository;


    @Test
    void shouldFollowUserSuccessfully() {
        // Arrange
        int userId = 9;
        int userIdToFollow = 4;

        // Act
        userRepository.follow(userId, userIdToFollow);

        // Assert
        assertTrue(userRepository.findById(userId).get().getFolloweds().contains(userIdToFollow));
        assertTrue(userRepository.findById(userIdToFollow).get().getFollowers().contains(userId));
    }
}