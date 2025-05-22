package com.example.be_java_hisp_w31_g01.integration;

import com.example.be_java_hisp_w31_g01.dto.PostPromoCountDto;
import com.example.be_java_hisp_w31_g01.dto.PostPromoDto;
import com.example.be_java_hisp_w31_g01.dto.PostRequestDto;
import com.example.be_java_hisp_w31_g01.dto.ProductDto;
import com.example.be_java_hisp_w31_g01.entity.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @Test
    void shouldCreatePostSuccessfully() throws Exception {
        PostRequestDto postDto = new PostRequestDto(
                1,
                LocalDate.parse("2025-04-15"),
                new ProductDto(1, "Galaxy S21", "Smartphone", "Samsung", "Phantom Gray", "128GB, 8GB RAM"),
                1,
                799.99
        );

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Publicación creada con éxito"));
    }

    @Test
    void shouldCreatePostRequestInvalid() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto();
        // Invalid user_id
        PostRequestDto invalidPostDto1 = new PostRequestDto(-1,
                LocalDate.parse("2025-04-15"),
                new ProductDto(1, "Galaxy S21", "Smartphone", "Samsung", "Phantom Gray", "128GB, 8GB RAM"),
                1,
                799.99
        );

        // Invalid date (future)
        PostRequestDto invalidPostDto2 = new PostRequestDto(1,
                LocalDate.parse("2035-04-15"),
                new ProductDto(1, "Galaxy S21", "Smartphone", "Samsung", "Phantom Gray", "128GB, 8GB RAM"),
                1,
                799.99
        );

        // Invalid product (null)
        PostRequestDto invalidPostDto3 = new PostRequestDto(1,
                LocalDate.parse("2025-04-15"),
                null,
                1,
                799.99
        );

        // Invalid category (negative)
        PostRequestDto invalidPostDto4 = new PostRequestDto(1,
                LocalDate.parse("2025-04-15"),
                new ProductDto(1, "Galaxy S21", "Smartphone", "Samsung", "Phantom Gray", "128GB, 8GB RAM"),
                -1,
                799.99
        );

        // Invalid price (negative)
        PostRequestDto invalidPostDto5 = new PostRequestDto(1,
                LocalDate.parse("2025-04-15"),
                new ProductDto(1, "Galaxy S21", "Smartphone", "Samsung", "Phantom Gray", "128GB, 8GB RAM"),
                1,
                -799.99
        );

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidPostDto1)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("user_id: El ID de usuario debe ser un número positivo"));

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidPostDto2)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("date: No puede ser una fecha futura"));

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidPostDto3)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("product: El producto es obligatorio"));

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidPostDto4)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("category: La categoría debe ser un número positivo"));

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidPostDto5)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("price: El precio debe ser mayor a cero"));


    }

    // T0010
    @Test
    void should_createPostPromo_when_validPostPromoDtoIsGiven() throws Exception {

        ProductDto productDto = new ProductDto(1,
                "Galaxy S21",
                "Smartphone",
                "Samsung",
                "Phantom Gray",
                "128GB, 8GB RAM"
        );

        PostPromoDto postPromoDto = new PostPromoDto(1,
                1,
                LocalDate.parse("2025-04-15"),
                productDto,
                1,
                799.99,
                true,
                10.0);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String jsonRequest = objectMapper.writeValueAsString(postPromoDto);

        this.mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("Publicación creada con éxito"));
    }

    @Test
    void deletePost_Successfully() throws Exception {
        int userId = 1;
        int postId = 8;

        mockMvc.perform(delete("/products/post/{userId}/{postId}", userId, postId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Se eliminó correctamente la publicación con ID " + postId +
                        " del usuario " + userId + "."));
    }

    @Test
    void deletePost_userIdMatchesButPostIdDifferent() throws Exception {
        Post postDelete = new Post();
        postDelete.setUser_id(1);
        postDelete.setPost_id(8);

        mockMvc.perform(delete("/products/post/{userId}/{postId}", 1, 99))
                        .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("No se encontró una publicación con ID " + 99 +
                                " para el usuario " + 1));
    }

    @Test
    void deletePost_postIdMatchesButUserIdDifferent() throws Exception {
        Post postDelete = new Post();
        postDelete.setUser_id(2);
        postDelete.setPost_id(7);

        mockMvc.perform(delete("/products/post/{userId}/{postId}", 99, 7))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("No se encontró una publicación con ID " + 7 +
                                                " para el usuario " + 99));

    }

    @Test
    void getPromoPostList_ReturnsOnlyPromoPosts() throws Exception {
        //Arrange
        int userId = 1;

        //Act & Assert
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/promo-post/list")
                        .param("user_id", String.valueOf(userId)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts[0].hasPromo").value(true));
    }

    @Test
    void deletePost_NotFound() throws Exception {
        int userId = 1;
        int postId = 999;

        mockMvc.perform(delete("/products/post/{userId}/{postId}", userId, postId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("No se encontró una publicación con ID " + postId +
                                " para el usuario " + userId));
    }

    @Test
    void GetPromoPostCount_Successfully() throws Exception {
        PostPromoCountDto postPromoCountDto = new PostPromoCountDto(3,"seller03",1);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count").
                param("user_id", String.valueOf(3)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(postPromoCountDto.getUser_id()))
                .andExpect(jsonPath("$.user_name").value(postPromoCountDto.getUser_name()))
                .andExpect(jsonPath("$.promo_products_count").value(postPromoCountDto.getPromo_products_count()));

    }

}