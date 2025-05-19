package com.mercadolibre.be_java_hisp_w31_g02.integration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Integration test - US-0008 - Followers name asc")
    public void followersList_correctOrder_nameAsc() throws Exception {
        this.mockMvc.perform(get("/users/{UserID}/followers/list", 1).queryParam("order", "name_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.followers[0].user_name").value("Emiliano Funes"));

    }

    @Test
    @DisplayName("Integration test - US-0008 - Followers name desc")
    public void followersList_correctOrder_nameDesc() throws Exception {
        this.mockMvc.perform(get("/users/{UserID}/followers/list", 1).queryParam("order", "name_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.followers[0].user_name").value("Maria Garcia"));

    }

    @Test
    @DisplayName("Integration test - US-0004 - Followed continue ok")
    public void followedList_continueOk() throws Exception {
        this.mockMvc.perform(
                get("/users/{userId}/followed/list", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userName").value("Juan Perez")
        );
    }

    @Test
    @DisplayName("Integration test - US-0004 - User not found")
    public void followedList_throwsNotFoundException() throws Exception {
        this.mockMvc.perform(
                        get("/users/{userId}/followed/list", 10000))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User doesn't exist"));
    }

    @Test
    @DisplayName("Integration test - US-0004 - User without followers")
    public void followedList_throwsFollowersEmpty() throws Exception {
        this.mockMvc.perform(
                        get("/users/{userId}/followed/list", 59))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No followers were found for this user."));
    }

    @Test
    @DisplayName("List of users who follow a seller")
    void getAllFollowersOfASeller_continueOk() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1)
                .param("order","name_asc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers.size()").value(2));
    }

    @Test
    @DisplayName("List of users who follow a seller - User - ERROR")
    void getAllFollowersOfASeller_throwsNotFoundExceptionUserEmpty() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list","253")
                .param("order","name_asc"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Not found seller Id:253"));
    }

    @Test
    @DisplayName("List of users who follow a seller - Followers - ERROR")
    void getAllFollowersOfASeller_throwsNotFoundExceptionFollowersEmpty() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", "59")
                                .param("order", "name_asc"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Not found followers for this seller."));
    }

    @DisplayName("Integration test - US-0002")
    @Test
    void getFollowersCount_shouldReturnNotFound_WhenUserDoesNotExist() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", 1000)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("No user found for the given ID"));
    }
    @Test
    @DisplayName("Integration test - US-0002")
    void getFollowersCount_getNumberOfFollowers_useValidUser() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 1)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.followers_count").value(2))
            .andExpect(jsonPath("$.user_name").value("Juan Perez"))
            .andExpect(jsonPath("$.user_id").value(1));
    }
    @Test
    @DisplayName("Integration test - US-0002")
    void getFollowersCount_getNumberOfFollowers_useAnInvalidValidUser() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", 1000)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("No user found for the given ID"));
    }
    @Test
    @DisplayName("Integration test - US-0001")
    void subscribeUserToUser_userFollowToAnotherFollow_PostTheNewRelation() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 20)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.idUser").value(1))
            .andExpect(jsonPath("$.idFollowedSeller").value(20));
    }
    @Test
    @DisplayName("Integration test - US-0001")
    void subscribeUserToUser_userFollowToAnotherFollow_theRelationAlreadyExists() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isConflict())
            .andExpect(jsonPath("$.message").value("The user already follows the seller"));
    }
    @Test
    @DisplayName("Integration test - US-0001")
    void subscribeUserToUser_userFollowToAnotherFollow_UserNotExists() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1000, 20)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("User not registered"));
    }
    @Test
    @DisplayName("Integration test - US-0001")
    void subscribeUserToUser_userFollowToAnotherFollow_SellerNotExists() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2000)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("Seller not registered"));
    }
    @Test
    @DisplayName("Unfollow OK - user-seller exist and remove follow")
    public void unfollow_shouldSucceed_whenUsersExist() throws Exception {
        this.mockMvc.perform(
                    put("/users/1/unfollow/6"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.message").value("The ID(1) follower of the ID(6) seller has been removed."));
    }
    @Test
    @DisplayName("Unfollow - user not exist")
    public void unfollow_shouldFail_whenUserDoesNotExist() throws Exception {
        this.mockMvc.perform(put("/users/9999/unfollow/2"))
               .andExpect(status().isNotFound())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.message").value("The user(9999) does not exist"));
    }
    @Test
    @DisplayName(" Unfollow - seller not exist")
    public void unfollow_shouldFail_whenSellerDoesNotExist() throws Exception {
        this.mockMvc.perform(put("/users/1/unfollow/9999"))
               .andExpect(status().isNotFound())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.message").value("The user(9999) does not exist"));
    }
    @Test
    @DisplayName("Unfollow - follow not exist")
    public void unfollow_shouldFail_whenUserDoesNotFollowSeller() throws Exception {
        this.mockMvc.perform(put("/users/4/unfollow/5")) 
               .andExpect(status().isNotFound())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.message").value("User(4) does not follow user(5)"));
    }
}
