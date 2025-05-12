package com.mercadolibre.groupfive.socialmeli.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.mercadolibre.groupfive.socialmeli.dto.PostDto;
import com.mercadolibre.groupfive.socialmeli.dto.ProductDto;
import com.mercadolibre.groupfive.socialmeli.util.UtilTest;
import org.springframework.test.web.servlet.ResultMatcher;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ResultActions resultActions;
    private static final String POST_URL = "/products/post";
    private static final MediaType JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON;

    private PostDto createPostDto(Integer userId, Double price, LocalDate publishDate, Integer category) {
        ProductDto productDto = createProductDto();
        return PostDto.builder()
                .userId(userId)
                .publishDate(publishDate)
                .productDto(productDto)
                .category(category)
                .price(price)
                .build();
    }

    private ProductDto createProductDto() {
        return new ProductDto(
                1,
                "Electronics",
                "Samsung",
                "Smartphone",
                "Black",
                "Latest model"
        );
    }

    private void performPostRequestAndExpect(String postJson, ResultMatcher status, String expectedMessage, String expression) throws Exception {
        this.mockMvc.perform(
                        post(POST_URL)
                                .contentType(JSON_CONTENT_TYPE)
                                .content(postJson))
                .andDo(print())
                .andExpect(status)
                .andExpect(jsonPath(expression).value(expectedMessage));
    }

    @Test
    public void shouldCreatePostSuccessfully() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(1, 1500D, LocalDate.of(2023, 10, 1), 100);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        this.mockMvc.perform(
                        post(POST_URL)
                                .contentType(JSON_CONTENT_TYPE)
                                .content(postJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnBadRequestWhenUserIdIsMissing() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(null, 1500D, LocalDate.of(2023, 10, 1), 100);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        performPostRequestAndExpect(postJson, status().isBadRequest(), "El id no puede estar vacío", "$.userId");
    }

    @Test
    public void shouldReturnBadRequestWhenUserIdIsLessThanZero() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(-1, 1500D, LocalDate.of(2023, 10, 1), 100);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        performPostRequestAndExpect(postJson, status().isBadRequest(), "El id debe ser mayor a cero", "$.userId");
    }

    @Test
    public void shouldReturnBadRequestWhenPublishDateIsNull() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(1, 1500D, null, 100);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        performPostRequestAndExpect(postJson, status().isBadRequest(), "La fecha no puede estar vacía", "$.publishDate");
    }

    @Test
    public void shouldReturnBadRequestWhenCategoryIsNull() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(1, 1500D, LocalDate.of(2023, 10, 1), null);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        performPostRequestAndExpect(postJson, status().isBadRequest(), "El campo no puede estar vacío", "$.category");
    }

    @Test
    public void shouldReturnBadRequestWhenPriceIsLessThanZero() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(1, 0D, LocalDate.of(2023, 10, 1), 100);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        performPostRequestAndExpect(postJson, status().isBadRequest(), "El precio no puede ser menor a 0", "$.price");
    }

    @Test
    public void shouldReturnBadRequestWhenPriceIsMoreThanTenMillions() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(1,11000000D , LocalDate.of(2023, 10, 1), 100);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        performPostRequestAndExpect(postJson, status().isBadRequest(), "El precio máximo por producto es de 10.000.000", "$.price");
    }

    @Test
    public void shouldReturnBadRequestWhenUserIdIsNotFound() throws Exception {
        // Arrange
        PostDto postDto = createPostDto(99999, 1500D, LocalDate.of(2023, 10, 1), 100);
        String postJson = UtilTest.generateFromDto(postDto);

        // Act & Assert
        performPostRequestAndExpect(postJson, status().isNotFound(), "No se encontró el usuario", "$.message");
    }

    @Test
    void testPostNewPromo() throws Exception {
        // Arrange
        ProductDto productDto = new ProductDto(1, "Silla gamer", "Razr", "Gamer", "Rojo", "Special edition");
        PostDto postDto = PostDto.builder()
                .userId(1)
                .publishDate(LocalDate.now())
                .productDto(productDto)
                .category(1)
                .price(100.0)
                .hasPromo(true)
                .discount(10.0)
                .build();

        String postDtoJson = UtilTest.generateFromDto(postDto);

        // Act & Assert

        mockMvc.perform(post("/products/promo-post")
                .contentType("application/json")
                .content(postDtoJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
    @Test
    void testGetAmountPromosBySeller() throws Exception {
        // Arrange
        Integer userId = 1;
        String url = "/products/promo-post/count?user_id=" + userId;

        // Act & Assert
        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetAmountPromosBySellerUserNotFound() throws Exception {
        // Arrange
        Integer userId = 99;
        String url = "/products/promo-post/count?user_id=" + userId;

        // Act & Assert
        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontró el usuario"));
    }

    @Test
    @DisplayName("Find posts given a range based on minimum and maximum price for posts to be found")
    void shouldPostByPriceReturnedWhenUserEntersMinAndMaxPriceRange() throws Exception{

        //Arrange
        String minPrice = "0.0", maxPrice = "100000.0", min = "min", max = "max";
        Double minPriceConverted = Double.valueOf(minPrice), maxPriceConverted = Double.valueOf(maxPrice);
        
        //Act
        resultActions = mockMvc.perform(get("/products/posts-by-price")
            .param(min, minPrice)
            .param(max, maxPrice));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[*].price", everyItem(greaterThanOrEqualTo(minPriceConverted))))
            .andExpect(jsonPath("$[*].price",  everyItem(lessThanOrEqualTo(maxPriceConverted))));

    }

    @Test
    @DisplayName("Return a BadRequestException when price range has been entered incorrectly ")
    void shouldPostByPriceReturnedWhenUserEntersMinAndMaxPriceRangeButMaxIsLessThanMin() throws Exception{

        //Arrange
        String minPrice = "500.0", maxPrice = "200.0", min = "min", max = "max";
        String messageExpected = "El rango de precios es incorrecto";
        
        //Act
        resultActions = mockMvc.perform(get("/products/posts-by-price")
            .param(min, minPrice)
            .param(max, maxPrice));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message", containsString(messageExpected)));
    }

    @Test
    @DisplayName("Return a NotFoundException when no post where found in the requested price range")
    void shouldNoPostByPriceReturnedWhenUserEntersMinAndMaxPriceRange() throws Exception{

        //Arrange
        String minPrice = "0", maxPrice = "0", min = "min", max = "max";
        String messageExpected = "No hay posts dentro del rango de precio establecido";
        
        //Act
        resultActions = mockMvc.perform(get("/products/posts-by-price")
            .param(min, minPrice)
            .param(max, maxPrice));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message", containsString(messageExpected)));
    }

    @Test
    @DisplayName ("Find all posts by brand")
    void shouldPostByBrandReturnedWhenUserEntersBrand() throws Exception{
        
        //Arrange
        String brand = "Samsung";

        //Act
        resultActions = mockMvc.perform(get("/products/posts-by-brand/{brand}", brand));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[*].product.brand", everyItem(containsString(brand))));
    }

    @Test
    @DisplayName ("Find no post by brand because of not found exception was triggered")
    void shouldNoPostByBrandReturnedWhenUserEntersBrand() throws Exception{
        
        //Arrange
        String brand = "akldjfaeo";
        String messageException = "No se encontraron posts de la marca";

        //Act
        resultActions = mockMvc.perform(get("/products/posts-by-brand/{brand}", brand));

        //Assert
        resultActions
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message", containsString(messageException)));
    }

    @Test
    @DisplayName("Should return posts by followed user")
    void shouldReturnPostsByFollowedUser() throws Exception {
        // Arrange
        Integer userId = 4;
        String order = "date_desc";
        String url = "/products/followed/{userId}/list";

        // Act
        resultActions = mockMvc.perform(get(url, userId)
                .param("order", order));

        // Assert
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.posts").isArray());
    }
}
