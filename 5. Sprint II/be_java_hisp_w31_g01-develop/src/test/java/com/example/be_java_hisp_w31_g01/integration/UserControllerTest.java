package com.example.be_java_hisp_w31_g01.integration;

import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import com.example.be_java_hisp_w31_g01.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserRepository userRepository;


    @Test
    void followSeller_userCannotFollowSelf_shouldReturnBadRequest() throws Exception {
        // Arrange
        int userId = 111;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Un usuario no puede seguirse a sí mismo."));
    }

    @Test
    void followSeller_alreadyFollowing_shouldReturnBadRequest() throws Exception {
        // Arrange
        int sellerId = 1;
        int customerId = 111;

        Customer customer = userRepository.findCustomerById(customerId);
        Seller seller = userRepository.findSellerById(sellerId);
        customer.getFollowed().add(seller);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", customerId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Comprador con ID " + customerId + " ya está siguiendo al vendedor con ID " + sellerId + "."));
    }

    @Test
    void followSeller_sellerNotFound_shouldReturnNotFound() throws Exception {
        // Arrange
        int customerId = 111;
        int nonExistentSellerId = 999;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", customerId, nonExistentSellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Vendedor con ID " + nonExistentSellerId + " no encontrado."));
    }

    @Test
    void followers_shouldReturnListOfFollowers() throws Exception {
        // Arrange
        int sellerId = 1;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers", hasSize(4)))
                .andExpect(jsonPath("$.followers[0].user_name").exists());
    }

    @Test
    void followers_noFollowers_shouldReturnNotFound() throws Exception {
        // Arrange
        int nonExistentSellerId = 999;

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", nonExistentSellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se han encontrado seguidores para el vendedor con id: " + nonExistentSellerId));
    }

    @Test
    void followers_invalidOrderParam_shouldReturnBadRequest() throws Exception {
        // Arrange
        int sellerId = 1;
        String invalidOrder = "invalid";

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId)
                        .param("order", invalidOrder)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Parámetro 'order' inválido. Debe ser 'name_asc' o 'name_desc'."));
    }

    @Test
    void followers_validOrderParam_shouldReturnOrderedFollowersAsc () throws Exception {
        // Arrange
        int sellerId = 1;
        String validOrder = "name_asc";

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId)
                        .param("order", validOrder)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers[0].user_name").value("customer01"))
                .andExpect(jsonPath("$.followers[1].user_name").value("customer02"));
    }

    @Test
    void followers_validOrderParam_shouldReturnOrderedFollowersDesc() throws Exception {
        // Arrange
        int sellerId = 1;
        String validOrder = "name_desc";

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId)
                        .param("order", validOrder)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers[1].user_name").value("customer11"))
                .andExpect(jsonPath("$.followers[0].user_name").value("customer12"));
    }

    @Test
    void testCountFollowers_ReturnsSellerDto() throws Exception {
        int userId = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("seller01"))
                .andExpect(jsonPath("$.followers_count").value(4));
    }

    @Test
    void unfollowSeller_ReturnsSuccessMessage() throws Exception {
        int userId = 110;
        int userIdToUnfollow = 5;

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Se ha dejado de seguir al vendedor con éxito"));
    }

    @Test
    void getFollowedList_ReturnsOkAndSortedResult() throws Exception {
        int userId = 109;

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", userId)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.followed.length()").value(1))
                .andExpect(jsonPath("$.followed[0].user_name").value("seller05"));
    }
}