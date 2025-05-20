package com.bootcamp.be_java_hisp_w31_g09.integration;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseMessageDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.ResponsePromoPostDTO;
import com.bootcamp.be_java_hisp_w31_g09.utils.CustomFactory;
import org.junit.jupiter.api.*;
import com.bootcamp.be_java_hisp_w31_g09.dto.UserDTO;
import com.bootcamp.be_java_hisp_w31_g09.entity.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();
    private Buyer buyer1;
    private UserDTO seller1;

    @BeforeEach
    public void setUp(){
        buyer1 = new Buyer(11, "Alice", List.of(1,2,3));
        seller1 = new UserDTO(6, "Sofia");
    }

    private List<Map<String, Object>> getRankingResponse(String orderParam) throws Exception {
        var requestBuilder = get("/users/followers/seller/ranking");
        if (orderParam != null) requestBuilder.param("order", orderParam);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String json = result.getResponse().getContentAsString();
        return mapper.readValue(json, new TypeReference<>() {});
    }
    @Test
    @DisplayName("TI_US_0013: Happy Path - Desc by default")
    public void testGetRankingFollowersSellerDefaultDesc() throws Exception {
        List<Map<String, Object>> response = getRankingResponse(null);
        int first = (int) response.get(0).get("followers_count");
        int last = (int) response.get(response.size() - 1).get("followers_count");

        assertTrue(first >= last, "El primero debería tener igual o más seguidores que el último");
    }


    @Test
    @DisplayName("TI_US_0013 A: Happy Path - Desc")
    public void testGetRankingFollowersSellerDesc() throws Exception {
        List<Map<String, Object>> response = getRankingResponse("date_desc");
        int first = (int) response.get(0).get("followers_count");
        int last = (int) response.get(response.size() - 1).get("followers_count");

        assertTrue(first >= last, "El primero debería tener igual o más seguidores que el último (orden descendente)");
    }

    @Test
    @DisplayName("TI_US_0013 B: Happy Path - Asc")
    public void testGetRankingFollowersSellerAsc() throws Exception {
        List<Map<String, Object>> response = getRankingResponse("date_asc");
        int first = (int) response.get(0).get("followers_count");
        int last = (int) response.get(response.size() - 1).get("followers_count");

        assertTrue(first <= last, "El primero debería tener igual o menos seguidores que el último (orden ascendente)");
    }

    @Test
    @DisplayName("TI_US_0013: Response is Empty Array")
    public void testGetRankingFollowersSellerReturnsArray() throws Exception {
        mockMvc.perform(get("/users/followers/seller/ranking"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    @DisplayName("Happy Path US-0012")
    public void testPromoList() throws Exception {
        // Arrange
        ResponsePromoPostDTO responsePromoPostDTO = CustomFactory.getPromoPostList();

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/list?user_id=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(responsePromoPostDTO.getId()))
                .andExpect(jsonPath("$.name").value(responsePromoPostDTO.getName()))
                .andExpect(jsonPath("$.posts.length()").value(1));
    }

    @Test
    @DisplayName("Empty US-0012")
    public void testPromoListEmpty() throws Exception {
        // Arrange
        ResponsePromoPostDTO responsePromoPostDTO = CustomFactory.getPromoPostListEmpty();

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/list?user_id=3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(responsePromoPostDTO.getId()))
                .andExpect(jsonPath("$.name").value(responsePromoPostDTO.getName()))
                .andExpect(jsonPath("$.posts.length()").value(0));
    }

    @Test
    @DisplayName("Not found US-0012")
    public void testPromoListUserNotFound() throws Exception {
        // Arrange
        ResponseMessageDTO response = CustomFactory.getSellerNotExistsMessage(99);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/list?user_id=99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }

    @Test
    @DisplayName("Happy path get followers")
    public void testGetSellerFollowers() throws Exception {
        int userId = 1;
        mockMvc.perform(get("/users/{userId}/followers/list", userId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.name").value("Juan"));
    }

    @Test
    @DisplayName("Seguidores ordenados por nombre ascendiente")
    public void testGetSellerFollowersOrderedByNameAsc() throws Exception {
        int userId = 1;

        mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "name_asc"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userList[0].user_name").value("Alice"));
    }

    @Test
    @DisplayName("Integration test us-0004: Not Found Buyer")
    public void testNotFoundBuyer() throws Exception {
        Integer invalidId = 999;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", invalidId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existe un usuario con id: "  + invalidId));
    }

    @Test
    @DisplayName("Integration test us-0008: Seller Not Found")
    public void testNotFoundSellerByOrder() throws Exception {
        Integer invalidId = 999;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=name_asc", invalidId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existe un vendedor con id: " + invalidId));;
    }

    @Test
    @DisplayName("Integration test us-0008: Buyer Not Found with Order")
    public void testNotFoundBuyerByOrder() throws Exception {
        Integer invalidId = 999;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_asc", invalidId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existe un usuario con id: " + invalidId));

    }

    @Test
    @DisplayName("Integration test us-0008: Invalid order for Followers")
    public void testGetFollowersInvalidOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=test", seller1.getUserId()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Ese orden no es válido."));
    }

    @Test
    @DisplayName("Integration test us-0008: Invalid order for Followed")
    public void testGetFollowedInvalidOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=test", buyer1.getId()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Ese orden no es válido."));
    }

    @Test
    @Order(1)
    @DisplayName("Integration test us-0004: Get Followers list")
    public void testValidBuyerGetSellersFollowed() throws Exception {
        UserDTO seller1 = new UserDTO(1, "Juan");
        UserDTO seller2 = new UserDTO(2, "Maria");
        UserDTO seller3 = new UserDTO(3, "Carlos");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", buyer1.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(buyer1.getId()))
                .andExpect(jsonPath("$.name").value(buyer1.getName()))
                .andExpect(jsonPath("$.userList.length()").value(3))
                .andExpect(jsonPath("$.userList[?(@.user_id == "+seller1.getUserId()+" && " +
                        "@.user_name == \""+seller1.getName()+"\")]").exists())
                .andExpect(jsonPath("$.userList[?(@.user_id == \""+seller2.getUserId()+"\"  && " +
                        "@.user_name == \""+seller2.getName()+"\")]").exists())
                .andExpect(jsonPath("$.userList[?(@.user_id == \""+seller3.getUserId()+"\"  && " +
                        "@.user_name == \""+seller3.getName()+"\")]").exists());
    }

    @Test
    @DisplayName("Integration test us-0008: Get Followed by Asc")
    public void testValidBuyerGetSellersFollowedByAsc() throws Exception {
        UserDTO seller1 = new UserDTO(1, "Juan");
        UserDTO seller2 = new UserDTO(2, "Maria");
        UserDTO seller3 = new UserDTO(3, "Carlos");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_asc",
                        buyer1.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(buyer1.getId()))
                .andExpect(jsonPath("$.name").value(buyer1.getName()))
                .andExpect(jsonPath("$.userList.length()").value(3))
                .andExpect(jsonPath("$.userList[0].user_name").value(seller3.getName()))
                .andExpect(jsonPath("$.userList[1].user_name").value(seller1.getName()))
                .andExpect(jsonPath("$.userList[2].user_name").value(seller2.getName()));
    }

    @Test
    @DisplayName("Integration test us-0008: Get Followed by Desc")
    public void testValidBuyerGetSellersFollowedByDesc() throws Exception {
        UserDTO seller1 = new UserDTO(1, "Juan");
        UserDTO seller2 = new UserDTO(2, "Maria");
        UserDTO seller3 = new UserDTO(3, "Carlos");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_desc",
                        buyer1.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(buyer1.getId()))
                .andExpect(jsonPath("$.name").value(buyer1.getName()))
                .andExpect(jsonPath("$.userList.length()").value(3))
                .andExpect(jsonPath("$.userList[0].user_name").value(seller2.getName()))
                .andExpect(jsonPath("$.userList[1].user_name").value(seller1.getName()))
                .andExpect(jsonPath("$.userList[2].user_name").value(seller3.getName()));

    }

    @Test
    @DisplayName("Integration test us-0008: Get Followers by Asc")
    public void testValidSellerGetFollowersByAsc() throws Exception {
        UserDTO buyer1 = new UserDTO(12, "Bob");
        UserDTO buyer2 = new UserDTO(13, "Charlie");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=name_asc",
                        seller1.getUserId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(seller1.getUserId()))
                .andExpect(jsonPath("$.name").value(seller1.getName()))
                .andExpect(jsonPath("$.userList.length()").value(2))
                .andExpect(jsonPath("$.userList[0].user_name").value(buyer1.getName()))
                .andExpect(jsonPath("$.userList[1].user_name").value(buyer2.getName()));
    }

    @Test
    @DisplayName("Integration test us-0008: Get Followers by Desc")
    public void testValidSellerGetFollowersByDesc() throws Exception {
        UserDTO buyer1 = new UserDTO(12, "Bob");
        UserDTO buyer2 = new UserDTO(13, "Charlie");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=name_desc",
                        seller1.getUserId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(seller1.getUserId()))
                .andExpect(jsonPath("$.name").value(seller1.getName()))
                .andExpect(jsonPath("$.userList.length()").value(2))
                .andExpect(jsonPath("$.userList[0].user_name").value(buyer2.getName()))
                .andExpect(jsonPath("$.userList[1].user_name").value(buyer1.getName()));
    }

    @Test
    @DisplayName("Integration test us-0008: Get Followed empty list")
    public void testEmptyFollowedList() throws Exception{
        Buyer buyer2 = new Buyer(14, "Peter", List.of());
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", buyer2.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(buyer2.getId()))
                .andExpect(jsonPath("$.name").value(buyer2.getName()))
                .andExpect(jsonPath("$.userList.length()").value(0));
    }

    @Test
    @DisplayName("Integration test us-0004: Followers empty list")
    public void testEmptyFollowersList() throws Exception{
        UserDTO seller2 = new UserDTO(10, "Lucia");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", seller2.getUserId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(seller2.getUserId()))
                .andExpect(jsonPath("$.name").value(seller2.getName()))
                .andExpect(jsonPath("$.userList.length()").value(0));
    }

    @Test
    @DisplayName("Happy Path Follow")
    public void testFollow() throws Exception {
        // Arrange
        ResponseMessageDTO response = CustomFactory.getFollowResponseMessage();

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/11/follow/5"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }

    @Test
    @DisplayName("Already follows")
    public void testFollowAlreadyFollows() throws Exception {
        // Arrange
        ResponseMessageDTO response = CustomFactory.getAlreadyFollowsMessage();

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/12/follow/5"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }

    @Test
    @DisplayName("Not Found Buyer Follow")
    public void testFollowBuyerNotExists() throws Exception {
        // Arrange
        ResponseMessageDTO response = CustomFactory.getBuyerNotExistsMessage(99);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/99/follow/5"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }

    @Test
    @DisplayName("Not Found Seller Follow")
    public void testFollowSellerNotExists() throws Exception {
        // Arrange
        ResponseMessageDTO response = CustomFactory.getSellerNotExistsMessage(99);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/11/follow/99"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(response.getMessage()));;
    }

    @Test
    @DisplayName("Integration Get followers list by SellerId")
    public void testGetFollowersCount() throws Exception {
        //Arrange
        int userId = 1;

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.followers_count").isNumber())
                .andExpect(jsonPath("$.user_name").isString());
    }

    @Test
    @DisplayName("Integration Get followers count for Seller not found")
    public void testGetFollowersCount_NotFoundSeller() throws Exception {
        //Arrange
        int userId = 999;
        ResponseMessageDTO response = CustomFactory.FollowersCountSellerNoExist(userId);

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(response.getMessage()));

    }

    @Test
    @DisplayName("Seguidores por nombre descendiente")
    public void testGetSellerFollowersOrderedByNameDesc() throws Exception {
        int userId = 1;

        mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "name_desc"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userList[0].user_name").value("Alice"));
    }

    @Test
    @DisplayName("Happy Path unfollow")
    public void testSuccessfulUnfollow() throws Exception {
        int existingBuyer = 11;
        int existingSeller = 1;
        mockMvc.perform(put("/users/{userId}/unfollow/{userIdToUnfollow}", existingBuyer, existingSeller))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Se ha dejado de seguir satisfactoriamente"));
    }

    @Test
    @DisplayName("Not Following unfollow")
    public void testUnfollowWhenNotFollowing() throws Exception {
        int existingBuyer = 11;
        int existingSeller = 6;
        mockMvc.perform(put("/users/{userId}/unfollow/{userIdToUnfollow}", existingBuyer, existingSeller))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El usuario no sigue al vendedor"));

    }

    @Test
    @DisplayName("Not Found buyer unfollow")
    public void testUnfollowNonExistingBuyer() throws Exception {
        int nonExistingBuyer = 999;
        int existingSeller = 2;
        mockMvc.perform(put("/users/{userId}/unfollow/{userIdToUnfollow}", nonExistingBuyer, existingSeller))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existe un usuario con id: " + nonExistingBuyer));
    }

    @Test
    @DisplayName("Not Found seller unfollow")
    public void testUnfollowNonExistingSeller() throws Exception {
        int existingBuyer = 11;
        int nonExistingSeller = 999;
        mockMvc.perform(put("/users/{userId}/unfollow/{userIdToUnfollow}", existingBuyer, nonExistingSeller))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existe un vendedor con id: " + nonExistingSeller));
    }

    @Test
    @DisplayName("Orden invalido get seguidores")
    public void testGetSellerFollowersInvalidOrderParameter() throws Exception {
        int userId = 1;

        mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "unknown_order"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Ese orden no es válido."));
    }

    @Test
    @DisplayName("Not Found get seguidores")
    public void testGetSellerFollowersNonExistingUser() throws Exception {
        int nonExistingUserId = 999;

        mockMvc.perform(get("/users/{userId}/followers/list", nonExistingUserId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existe un vendedor con id: " + nonExistingUserId));
    }
}
