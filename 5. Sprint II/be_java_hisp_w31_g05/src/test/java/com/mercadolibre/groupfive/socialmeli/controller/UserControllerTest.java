package com.mercadolibre.groupfive.socialmeli.controller;

import java.util.List;

import com.mercadolibre.groupfive.socialmeli.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.mercadolibre.groupfive.socialmeli.util.UtilTest.generateFromDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.mercadolibre.groupfive.socialmeli.util.UtilTest;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFollowersCountWhenUserExists() throws Exception {
        // Arrange
        Integer userId = 2;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(2))
                .andExpect(jsonPath("$.user_name").value("John"))
                .andExpect(jsonPath("$.followersCount").value(4));
    }

    @Test
    void shouldNotFollowersCountWhenUserDoesNotExist() throws Exception {
        // Arrange
        Integer missingUserId = 200;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", missingUserId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontró el usuario"));
    }

    @Test
    void shouldFollowedListWhenUserExists() throws Exception {
        // Arrange
        Integer userId = 1;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Michell"))
                .andExpect(jsonPath("$.followedList").isArray())
                .andExpect(jsonPath("$.followedList.length()").value(4))
                .andExpect(jsonPath("$.followedList[0].user_id").value(2))
                .andExpect(jsonPath("$.followedList[0].user_name").value("John"))
                .andExpect(jsonPath("$.followedList[1].user_id").value(4))
                .andExpect(jsonPath("$.followedList[1].user_name").value("Alice"));
    }

    @Test
    void shouldNotFollowedListWhenUserDoesNotExist() throws Exception {
        // Arrange
        Integer missingUserId = 200;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", missingUserId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontró el usuario"));
    }

    @Test
    void testFollowManyUsers() throws Exception {
        // Arrange
        Integer userId = 8;
        List<Integer> userIdsToFollow = List.of(7, 9, 10);

        String userIdsToFollowJson = UtilTest.generateFromList(userIdsToFollow);

        // Act & Assert
        mockMvc.perform(put("/users/{userId}/follow", userId)
                .contentType("application/json")
                .content(userIdsToFollowJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testFollowManyUsersUserNotExists() throws Exception {
        // Arrange
        Integer userId = 99;
        List<Integer> userIdsToFollow = List.of(1, 2, 3);

        String userIdsToFollowJson = UtilTest.generateFromList(userIdsToFollow);

        // Act & Assert
        mockMvc.perform(put("/users/{userId}/follow", userId)
                .contentType("application/json")
                .content(userIdsToFollowJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontró el usuario"));
    }

    @Test
    void testFollowManyUsersAlreadyFollowed() throws Exception {
        // Arrange
        Integer userId = 1;
        List<Integer> userIdsToFollow = List.of(2, 4);

        String userIdsToFollowJson = UtilTest.generateFromList(userIdsToFollow);

        // Act & Assert
        mockMvc.perform(put("/users/{userId}/follow", userId)
                .contentType("application/json")
                .content(userIdsToFollowJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario ya sigue al usuario a seguir"));
    }

    @Test
    void shouldFollowersListWhenUserExists() throws Exception {

        // Arrange
        Integer userId = 1;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Michell"))
                .andExpect(jsonPath("$.followersList").isArray())
                .andExpect(jsonPath("$.followersList.length()").value(4))
                .andExpect(jsonPath("$.followersList[0].user_id").value(2))
                .andExpect(jsonPath("$.followersList[0].user_name").value("John"))
                .andExpect(jsonPath("$.followersList[1].user_id").value(3))
                .andExpect(jsonPath("$.followersList[1].user_name").value("Jane"));
    }

    @Test
    void shouldReturnOkWhenUserUnFollowManyUsers() throws Exception {
        // Arrange
        Integer userId = 7;
        List<Integer> followeds = List.of(4, 6);
        UserDto userDto = UserDto.builder()
                .followeds(followeds)
                .build();

        String userDtoJson = generateFromDto(userDto);

        // Act and Assert
        mockMvc.perform(put("/users/{userId}/unfollow", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDtoJson))
                .andExpect(status().isOk());
    }


    @Test
    void shouldReturnNotFoundWhenUserTryUnFollowUsersThatNotExist() throws Exception {
        Integer userId = 1;
        List<Integer> followeds = List.of(50, 64);

        UserDto userDto = UserDto.builder()
                .followeds(followeds)
                .build();

        String userDtoJson = generateFromDto(userDto);

        mockMvc.perform(put("/users/{userId}/unfollow", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDtoJson))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnOkWhenUserFollowAnotherUser() throws Exception {
        Integer userId = 7;
        Integer userIdToFollow = 10;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isOk());

    }

    @Test
    void shouldReturnNotFoundWhenUserFollowAnotherUserThatNotExists() throws Exception {
        Integer userId = 1;
        Integer userIdToFollow = 50;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isNotFound());

    }

    @Test
    void shouldReturnBadRequestWhenUserTryFollowAlreadyUserFollowed() throws Exception {
        Integer userId = 1;
        Integer userIdToFollow = 8;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isBadRequest());

    }

    @Test
    void shouldReturnBadRequestWhenUserTryFollowThemeSelves() throws Exception {
        Integer userId = 1;
        Integer userIdToFollow = 1;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isBadRequest());

    }

    @Test
    void shouldReturnListOfMostPopularUsers() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/most-popular")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].followersCount").value(4))
                .andExpect(jsonPath("$.[0].user_id").value(1))
                .andExpect(jsonPath("$.[0].user_name").value("Michell"))
                .andExpect(jsonPath("$.[1].followersCount").value(4))
                .andExpect(jsonPath("$.[1].user_id").value(2))
                .andExpect(jsonPath("$.[1].user_name").value("John"));
    }

    @Test
    void shouldUnfollowUserSuccessfully() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        // Act & Assert
        mockMvc.perform(put("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
