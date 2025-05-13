package com.example.be_java_hisp_w31_g01.controller;

import com.example.be_java_hisp_w31_g01.dto.*;
import com.example.be_java_hisp_w31_g01.exception.BadRequestException;
import com.example.be_java_hisp_w31_g01.exception.NotFoundException;
import com.example.be_java_hisp_w31_g01.service.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @Mock
    IPostService postService;

    @InjectMocks
    ProductController productController;

    // T0006
    @Test
    void should_returnHttpStatusOKAndBody_when_dateDesc() {

        // Arrange
        int userId = 101;
        String order = "date_desc";

        ProductDto product1 = new ProductDto(1,
                                            "Galaxy S21",
                                            "Smartphone",
                                            "Samsung",
                                            "Phantom Gray",
                                            "128GB, 8GB RAM");

        ProductDto product2 = new ProductDto(2,
                                            "MacBook Air",
                                            "Laptop",
                                            "Apple",
                                            "Space Gray",
                                            "M2 chip, 256GB SSD");

        PostResponseDto post1 = new PostResponseDto(1,
                                                    1,
                                                    LocalDate.parse("2025-04-15"),
                                                    product1,
                                                    1,
                                                    799.99);

        PostResponseDto post2 = new PostResponseDto(2,
                                                    2,
                                                    LocalDate.parse("2025-04-16"),
                                                    product2,
                                                    2,
                                                    999.99);

        PostResponseWrapperDto postResponseWrapperDto = new PostResponseWrapperDto(userId, List.of(post1, post2));

        when(postService.getFollowedSellerPostsInLastTwoWeeks(userId, order)).thenReturn(postResponseWrapperDto);

        // Act
        ResponseEntity<?> result = productController.getFollowedPosts(userId, order);

        // Assert
        assertTrue(result.hasBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void should_returnHttpStatusOKAndBody_when_dateAsc() {

        // Arrange
        int userId = 101;
        String order = "date_asc";

        ProductDto product1 = new ProductDto(1,
                                            "Galaxy S21",
                                            "Smartphone",
                                            "Samsung",
                                            "Phantom Gray",
                                            "128GB, 8GB RAM");

        ProductDto product2 = new ProductDto(2,
                                            "MacBook Air",
                                            "Laptop",
                                            "Apple",
                                            "Space Gray",
                                            "M2 chip, 256GB SSD");

        PostResponseDto post1 = new PostResponseDto(1,
                                                    1,
                                                    LocalDate.parse("2025-04-15"),
                                                    product1,
                                                    1,
                                                    799.99);

        PostResponseDto post2 = new PostResponseDto(2,
                                                    2,
                                                    LocalDate.parse("2025-04-16"),
                                                    product2,
                                                    2,
                                                    999.99);

        PostResponseWrapperDto postResponseWrapperDto = new PostResponseWrapperDto(userId, List.of(post1, post2));

        when(postService.getFollowedSellerPostsInLastTwoWeeks(userId, order)).thenReturn(postResponseWrapperDto);

        // Act
        ResponseEntity<?> result = productController.getFollowedPosts(userId, order);

        // Assert
        assertTrue(result.hasBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void should_returnHttpStatusOKAndBody_when_orderIsNull() {

        // Arrange
        int userId = 101;

        ProductDto product1 = new ProductDto(1,
                                            "Galaxy S21",
                                            "Smartphone",
                                            "Samsung",
                                            "Phantom Gray",
                                            "128GB, 8GB RAM");

        ProductDto product2 = new ProductDto(2,
                                            "MacBook Air",
                                            "Laptop",
                                            "Apple",
                                            "Space Gray",
                                            "M2 chip, 256GB SSD");

        PostResponseDto post1 = new PostResponseDto(1,
                                                    1,
                                                    LocalDate.parse("2025-04-15"),
                                                    product1,
                                                    1,
                                                    799.99);

        PostResponseDto post2 = new PostResponseDto(2,
                                                    2,
                                                    LocalDate.parse("2025-04-16"),
                                                    product2,
                                                    2,
                                                    999.99);

        PostResponseWrapperDto postResponseWrapperDto = new PostResponseWrapperDto(userId, List.of(post1, post2));

        when(postService.getFollowedSellerPostsInLastTwoWeeks(userId, null)).thenReturn(postResponseWrapperDto);

        // Act
        ResponseEntity<?> result = productController.getFollowedPosts(userId, null);

        // Assert
        assertTrue(result.hasBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void should_returnHttpStatusOKAndBody_when_orderIsEmpty() {

        // Arrange
        int userId = 101;
        String order = "";

        ProductDto product1 = new ProductDto(1,
                                            "Galaxy S21",
                                            "Smartphone",
                                            "Samsung",
                                            "Phantom Gray",
                                            "128GB, 8GB RAM");

        ProductDto product2 = new ProductDto(2,
                                            "MacBook Air",
                                            "Laptop",
                                            "Apple",
                                            "Space Gray",
                                            "M2 chip, 256GB SSD");

        PostResponseDto post1 = new PostResponseDto(1,
                                                    1,
                                                    LocalDate.parse("2025-04-15"),
                                                    product1,
                                                    1,
                                                    799.99);

        PostResponseDto post2 = new PostResponseDto(2,
                                                    2,
                                                    LocalDate.parse("2025-04-16"),
                                                    product2,
                                                    2,
                                                    999.99);

        PostResponseWrapperDto postResponseWrapperDto = new PostResponseWrapperDto(userId, List.of(post1, post2));

        when(postService.getFollowedSellerPostsInLastTwoWeeks(userId, order)).thenReturn(postResponseWrapperDto);

        // Act
        ResponseEntity<?> result = productController.getFollowedPosts(userId, order);

        // Assert
        assertTrue(result.hasBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void should_throwBadRequestException_when_invalidOrder() {

        // Arrange
        int userId = 101;
        String order = "invalid_order";

        when(postService.getFollowedSellerPostsInLastTwoWeeks(userId, order))
                .thenThrow(new BadRequestException("Parámetro 'order' inválido. Debe ser 'date_asc' o 'date_desc'."));

        // Act & Assert
        assertThrows(BadRequestException.class, () ->
                productController.getFollowedPosts(userId, order));
    }

    @Test
    void should_throwNotFoundException_when_noFollowedSellers() {

        // Arrange
        int userId = 101;
        String order = "date_desc";

        when(postService.getFollowedSellerPostsInLastTwoWeeks(userId, order))
                .thenThrow(new NotFoundException("Comprador con ID 101 no sigue a ningún vendedor."));

        // Act & Assert
        assertThrows(NotFoundException.class, () ->
                productController.getFollowedPosts(userId, order));
    }

    // T0009
    @Test
    void should_returnHttpStatusOkForNewProductPromo_when_validPostPromoDtoIsGiven() {

        // Arrange
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

        // Act
        ResponseEntity<?> result = productController.newProductPromo(postPromoDto);

        // Assert
        verify(postService).newPostPromo(postPromoDto);

        assertTrue(result.hasBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Publicación creada con éxito", result.getBody());
    }

    @Test
    void createPost() {
        // Arrange
        PostRequestDto postDto = new PostRequestDto(
                1,
                LocalDate.parse("2025-04-15"),
                new ProductDto(1, "Galaxy S21", "Smartphone", "Samsung", "Phantom Gray", "128GB, 8GB RAM"),
                1,
                799.99
        );

        doNothing().when(postService).createPost(postDto);

        // Act
        ResponseEntity<?> response = productController.createPost(postDto);

        // Assert
        verify(postService).createPost(postDto);
        System.out.println("Response Body: " + response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Publicación creada con éxito", response.getBody());
    }

    @Test
    void deletePost() {
        //Arrange
        int userId = 1;
        int postId = 7;

        doNothing().when(postService).deletePost(userId, postId);

        // Act
        ResponseEntity<?> response = productController.deletePost(userId, postId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se eliminó correctamente la publicación con ID " + postId +
                " del usuario " + userId + ".", response.getBody());
        verify(postService).deletePost(userId, postId);
    }
}