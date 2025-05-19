package com.mercadolibre.be_java_hisp_w31_g02.integration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@Tag("IntegrationTest")
@SpringBootTest
@AutoConfigureMockMvc
public class PublicationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("Post a publication status ok")
    void createPublicationWithPromo_statusOK() throws Exception{
        String jsonPublication = """
        {
             "user_id": 1,
             "date": "29-04-2021",
             "product": {
                 "product_id": 1,
                 "product_name": "Silla Gamer",
                 "type": "Gamer",
                 "brand": "Racer",
                 "color": "Red & Black",
                 "notes": "Special Edition"
             },
             "category": 100,
             "price": 1500.50
         }
                """;
        mockMvc.perform(
                MockMvcRequestBuilders.post("/products/promo-post")
                .content(jsonPublication)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(jsonPath("$").value("Publication created successfully"));
    }

    @Test
    @DisplayName("Post a publication without product - Error")
    void createPublicationWithoutProduct_statusConflict() throws Exception{

        String jsonPublicationWithoutProductDto = """
        {
            "user_id": 123,
            "date": "29-04-2021",
            "category": 100,
            "price": 1500.50
        }
        """;

        mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPublicationWithoutProductDto))
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value("createPublication.publicationDto.product: Product must not be null"));
    }

    @Test
    @DisplayName("Post a publication without userID - Error")
    void createPublicationWithoutUserId_statusConflict() throws Exception {
        String jsonPublicationWithoutUserIdDto = """
                {
                    "date": "29-04-2021",
                    "product": {
                        "product_id": 1,
                        "product_name": "Silla Gamer",
                        "type": "Gamer",
                        "brand": "Racer",
                        "color": "Red & Black",
                        "notes": "Special Edition"
                    },
                    "category": 100,
                    "price": 1500.50
                }
                """;
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonPublicationWithoutUserIdDto))
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value("createPublication.publicationDto.user_id: The user_id must not be null"));
    }

    @DisplayName("ft-ITest-US0006 \n" +
            "Returns posts from followed sellers that have a publication date within the last two weeks of today's date. - date_desc")
    @Test
    public void getPublicationsFollowedByAnUser_shouldReturnListOfPublications_WhenWithinTwoWeeks() throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list", 1)
                        .param("order", "date_desc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(Matchers.greaterThan(0))) // Al menos una publicación
                .andExpect(jsonPath("$[0].date").value(
                Matchers.greaterThan(LocalDate.now().minusWeeks(2).toString())));
    }

    @DisplayName("Test-US006 - Error user not exist")
    @Test
    void getPublicationsFollowedByAnUser_userNotExist() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.get("/products/followed/{userId}/list",100)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Does not exist a user with that id "));
    }

    @Test
    @DisplayName("Integration test - US-0009")
    void integrationTest_getPublicationsFollowedByAnUser() throws Exception{
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/1/list")
                                .param("order","date_desc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].user_id").value(2))
                .andExpect(jsonPath("$[0].user_name").value("Maria Garcia"));
    }

    @Test
    @DisplayName("Integration test error - US-0009")
    void integrationTest_getPublicationsFollowedByAnUser_ErrorNotFound() throws Exception{
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/189/list")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Does not exist a user with that id "));
    }
}
