package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.dto.*;
import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Post;
import com.example.be_java_hisp_w31_g01.entity.Product;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import com.example.be_java_hisp_w31_g01.exception.BadRequestException;
import com.example.be_java_hisp_w31_g01.exception.NotFoundException;
import com.example.be_java_hisp_w31_g01.repository.IPostRepository;
import com.example.be_java_hisp_w31_g01.repository.IUserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @Mock
    IUserRepository userRepository;
    @Mock
    IPostRepository postRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    void createPost() throws JsonProcessingException {
        //Arrange
        ProductDto productDto = new ProductDto(
                1,
                "Galaxy S21",
                "Smartphone",
                "Samsung",
                "Phantom Gray",
                "128GB, 8GB RAM"
        );

        PostRequestDto postRequestDto = new PostRequestDto(
                1, // userId
                LocalDate.parse("2025-04-15"),
                productDto,
                58, // category
                799.99
        );

        doNothing().when(postRepository).savePost(any(Post.class));

        //Act
        postService.createPost(postRequestDto);

        //Assert
        ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);
        verify(postRepository, times(1)).savePost(postCaptor.capture());

        Post savedPost = postCaptor.getValue();
        System.out.println("Saved Post: " + mapper.writeValueAsString(savedPost));
    }

    @Test
    void ShouldReturn_DTOPostPromoCountDTO_When_getPromoPostCountGetValidSeller() {
        //Arrange
        Seller mockSeller = new Seller();
        mockSeller.setUser_id(1);
        mockSeller.setUser_name("mockSeller");
        List<Post> mockPosts = Arrays.asList(
                new Post(), new Post(), new Post());
        when(userRepository.findSellerById(1)).thenReturn(mockSeller);
        when(postRepository.getPromoPost(Mockito.anyInt())).thenReturn(mockPosts);
        PostPromoCountDto expected = new PostPromoCountDto();
        expected.setPromo_products_count(3);
        expected.setUser_name("mockSeller");
        expected.setUser_id(1);
        //Act
        PostPromoCountDto result = postService.getPromoPostCount(1);
        //Assert
        assertEquals(expected.getPromo_products_count(), result.getPromo_products_count());
        assertEquals(expected.getUser_name(), result.getUser_name());
        assertEquals(expected.getUser_id(), result.getUser_id());
        verify(userRepository).findSellerById(1);
        verify(postRepository).getPromoPost(1);
    }

    @Test
    void ShouldThrow_NotFoundException_When_getPromoPostCountGetInvalidSeller() {
        //Arrange
        when(userRepository.findSellerById(1)).thenReturn(null);

        //Act and Assert
        Assertions.assertThrows(NotFoundException.class, () -> postService.getPromoPostCount(1));
    }

    @Test //vendedor no existe
    void getPromoPostList_SellerNotFound_ThrowsNotFoundException() {
        //Arrange
        int userId = 99;
        when(userRepository.findSellerById(userId)).thenReturn(null);

        //Act & Assert
        NotFoundException ex = assertThrows(NotFoundException.class, () -> {
            postService.getPromoPostList(userId);
        });
        assertEquals("Usuario con id: 99 no se encontró.", ex.getMessage());
    }

    @Test //vendedor sin productos en promo
    void getPromoPostList_NoPromoPosts_ThrowsNotFoundException() {
        int userId = 1;
        Seller seller1 = new Seller();
        seller1.setUser_id(userId);
        seller1.setUser_name("Vendedor1");

        when(userRepository.findSellerById(userId)).thenReturn(seller1);
        when(postRepository.getPromoPost(userId)).thenReturn(List.of());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> {
            postService.getPromoPostList(userId);
        });

        assertEquals("Vendedor con id: 1 no tiene productos con promo.", ex.getMessage());
    }

    @Test //promo post devueltos correctamente
    void getPromoPostList_WithPromoPosts_ReturnsDto() {
        //Arrange
        int userId = 1;
        Seller seller = new Seller();
        seller.setUser_id(userId);
        seller.setUser_name("Vendedor1");
        Product product = new Product(101, "Heladera No Frost", "Electrodoméstico", "Samsung", "Silver", "");
        Post post = new Post(1, userId, LocalDate.now(), product, 200, 350000.0, true, 0.15);

        when(userRepository.findSellerById(userId)).thenReturn(seller);
        when(postRepository.getPromoPost(userId)).thenReturn(List.of(post));

        //Act
        PostPromoWrapperDto result = postService.getPromoPostList(userId);

        //Assert
        assertEquals("Vendedor1", result.getUser_name());
        assertEquals(1, result.getPosts().size());
        assertTrue(result.getPosts().get(0).isHasPromo());
    }

    // T0006
    @Test
    void should_getFollowedSellerPostsInLastTwoWeeks_when_dateAsc() {

        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");

        Seller seller1 = new Seller();
        seller1.setUser_id(1);
        seller1.setUser_name("seller01");

        Seller seller2 = new Seller();
        seller2.setUser_id(4);
        seller2.setUser_name("seller04");

        customer.setFollowed(List.of(seller1, seller2));

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setUser_id(1);
        post1.setDate(LocalDate.now().minusDays(5));

        Post post2 = new Post();
        post2.setPost_id(2);
        post2.setUser_id(4);
        post2.setDate(LocalDate.now().minusDays(10));

        when(userRepository.findCustomerById(101)).thenReturn(customer);
        when(postRepository.findAllPosts()).thenReturn(List.of(post1, post2));

        // Act
        PostResponseWrapperDto response = postService.getFollowedSellerPostsInLastTwoWeeks(101, "date_asc");

        // Assert
        assertNotNull(response);
        assertEquals(2, response.getPosts().size());
        assertEquals(2, response.getPosts().get(0).getPost_id());
        assertEquals(1, response.getPosts().get(1).getPost_id());
    }

    // T0006
    @Test
    void should_getFollowedSellerPostsInLastTwoWeeks_when_dateDesc() {

        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");

        Seller seller1 = new Seller();
        seller1.setUser_id(1);
        seller1.setUser_name("seller01");

        Seller seller2 = new Seller();
        seller2.setUser_id(4);
        seller2.setUser_name("seller04");

        customer.setFollowed(List.of(seller1, seller2));

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setUser_id(1);
        post1.setDate(LocalDate.now().minusDays(5));

        Post post2 = new Post();
        post2.setPost_id(2);
        post2.setUser_id(4);
        post2.setDate(LocalDate.now().minusDays(10));

        when(userRepository.findCustomerById(101)).thenReturn(customer);
        when(postRepository.findAllPosts()).thenReturn(List.of(post1, post2));

        // Act
        PostResponseWrapperDto response = postService.getFollowedSellerPostsInLastTwoWeeks(101, "date_desc");

        // Assert
        assertNotNull(response);
        assertEquals(2, response.getPosts().size());
        assertEquals(1, response.getPosts().get(0).getPost_id());
        assertEquals(2, response.getPosts().get(1).getPost_id());
    }

    // T0006
    @Test
    void should_getFollowedSellerPostsInLastTwoWeeks_when_orderIsNull() {

        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");

        Seller seller1 = new Seller();
        seller1.setUser_id(1);
        seller1.setUser_name("seller01");

        Seller seller2 = new Seller();
        seller2.setUser_id(4);
        seller2.setUser_name("seller04");

        customer.setFollowed(List.of(seller1, seller2));

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setUser_id(1);
        post1.setDate(LocalDate.now().minusDays(5));

        Post post2 = new Post();
        post2.setPost_id(2);
        post2.setUser_id(4);
        post2.setDate(LocalDate.now().minusDays(10));

        when(userRepository.findCustomerById(101)).thenReturn(customer);
        when(postRepository.findAllPosts()).thenReturn(List.of(post1, post2));

        // Act
        PostResponseWrapperDto response = postService.getFollowedSellerPostsInLastTwoWeeks(101, null);

        // Assert
        assertNotNull(response);
        assertEquals(2, response.getPosts().size());
        assertEquals(1, response.getPosts().get(0).getPost_id());
    }

    // T0006
    @Test
    void should_getFollowedSellerPostsInLastTwoWeeks_when_orderIsEmpty() {

        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");

        Seller seller1 = new Seller();
        seller1.setUser_id(1);
        seller1.setUser_name("seller01");

        Seller seller2 = new Seller();
        seller2.setUser_id(4);
        seller2.setUser_name("seller04");

        customer.setFollowed(List.of(seller1, seller2));

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setUser_id(1);
        post1.setDate(LocalDate.now().minusDays(5));

        Post post2 = new Post();
        post2.setPost_id(2);
        post2.setUser_id(4);
        post2.setDate(LocalDate.now().minusDays(10));

        when(userRepository.findCustomerById(101)).thenReturn(customer);
        when(postRepository.findAllPosts()).thenReturn(List.of(post1, post2));

        // Act
        PostResponseWrapperDto response = postService.getFollowedSellerPostsInLastTwoWeeks(101, "");

        // Assert
        assertNotNull(response);
        assertEquals(2, response.getPosts().size());
        assertEquals(1, response.getPosts().get(0).getPost_id());
    }

    // T0006
    @Test
    void should_returnNoFollowedSellerPosts_when_postIsNotFromFollowedSeller() {

        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");

        Seller seller1 = new Seller();
        seller1.setUser_id(1);
        seller1.setUser_name("seller01");

        Seller seller2 = new Seller();
        seller2.setUser_id(4);
        seller2.setUser_name("seller04");

        customer.setFollowed(List.of(seller1, seller2));

        Post post = new Post();
        post.setPost_id(3);
        post.setUser_id(5);
        post.setDate(LocalDate.now().minusDays(5));

        when(userRepository.findCustomerById(101)).thenReturn(customer);
        when(postRepository.findAllPosts()).thenReturn(List.of(post));

        // Act
        PostResponseWrapperDto response = postService.getFollowedSellerPostsInLastTwoWeeks(101, "date_asc");

        // Assert
        assertNotNull(response);
        assertEquals(0, response.getPosts().size());
    }

    // T0006
    @Test
    void should_throwNotFoundExceptionForGetFollowedSellerPostsInLastTwoWeeks_when_followedIsEmpty() {
        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");
        customer.setFollowed(Collections.emptyList());

        when(userRepository.findCustomerById(101)).thenReturn(customer);

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            postService.getFollowedSellerPostsInLastTwoWeeks(101, "date_desc");
        });

        assertEquals("Comprador con ID 101 no sigue a ningún vendedor.", exception.getMessage());
    }

    // T0006
    @Test
    void should_throwBadRequestExceptionForGetFollowedSellerPostsInLastTwoWeeks_when_invalidOrder() {
        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");

        Seller seller1 = new Seller();
        seller1.setUser_id(1);
        seller1.setUser_name("seller01");

        Seller seller2 = new Seller();
        seller2.setUser_id(4);
        seller2.setUser_name("seller04");

        customer.setFollowed(List.of(seller1, seller2));

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setUser_id(1);
        post1.setDate(LocalDate.now().minusDays(5));

        Post post2 = new Post();
        post2.setPost_id(2);
        post2.setUser_id(4);
        post2.setDate(LocalDate.now().minusDays(10));

        when(userRepository.findCustomerById(101)).thenReturn(customer);

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            postService.getFollowedSellerPostsInLastTwoWeeks(101, "invalid_order");
        });

        assertEquals("Parámetro 'order' inválido. Debe ser 'date_asc' o 'date_desc'.", exception.getMessage());
    }

    // T0008
    @Test
    void should_getFollowedSellerPostsInLastTwoWeeks_when_postsAreInLastTwoWeeks() {

        // Arrange
        Customer customer = new Customer();
        customer.setUser_id(101);
        customer.setUser_name("customer01");

        Seller seller1 = new Seller();
        seller1.setUser_id(1);
        seller1.setUser_name("seller01");

        Seller seller2 = new Seller();
        seller2.setUser_id(4);
        seller2.setUser_name("seller04");

        customer.setFollowed(List.of(seller1, seller2));

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setUser_id(1);
        post1.setDate(LocalDate.now().minusDays(5));

        Post post2 = new Post();
        post2.setPost_id(2);
        post2.setUser_id(4);
        post2.setDate(LocalDate.now().minusDays(10));

        Post post3 = new Post();
        post3.setPost_id(3);
        post3.setUser_id(1);
        post3.setDate(LocalDate.now().minusDays(20));

        when(userRepository.findCustomerById(101)).thenReturn(customer);
        when(postRepository.findAllPosts()).thenReturn(List.of(post1, post2, post3));

        // Act
        PostResponseWrapperDto response = postService.getFollowedSellerPostsInLastTwoWeeks(101, "date_desc");

        // Assert
        assertNotNull(response);
        assertEquals(2, response.getPosts().size());
        assertTrue(response.getPosts().stream().allMatch(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2))));
    }

    // T0009
    @Test
    void should_createPostPromo_when_validPostPromoDtoIsGiven() {

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

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Post expectedPost = objectMapper.convertValue(postPromoDto, Post.class);

        // Act
        postService.newPostPromo(postPromoDto);

        // Assert
        ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);

        verify(postRepository).newPostPromo(postCaptor.capture());

        Post capturedPost = postCaptor.getValue();

        assertThat(capturedPost)
                .isNotNull()
                .extracting("post_id", "user_id", "price", "hasPromo", "discount", "category")
                .containsExactly(expectedPost.getPost_id(), expectedPost.getUser_id(), expectedPost.getPrice(),
                        expectedPost.isHasPromo(), expectedPost.getDiscount(), expectedPost.getCategory());

        assertThat(capturedPost.getProduct())
                .isNotNull()
                .extracting("product_id", "product_name", "type", "brand", "color", "notes")
                .containsExactly(expectedPost.getProduct().getProduct_id(), expectedPost.getProduct().getProduct_name(),
                        expectedPost.getProduct().getType(), expectedPost.getProduct().getBrand(),
                        expectedPost.getProduct().getColor(), expectedPost.getProduct().getNotes());

    }

    @Test
    void deletePost_success() {
        // Arrange
        Post postDelete = new Post();
        postDelete.setUser_id(1);
        postDelete.setPost_id(7);

        when(postRepository.findAllPosts()).thenReturn(List.of(postDelete));

        // Act & Assert
        assertDoesNotThrow(() -> postService.deletePost(1,7));
        verify(postRepository, times(1)).deletePost(postDelete);
    }

    @Test
    void deletePost_userIdMatchesButPostIdDifferent() {
        // Arrange
        Post postDelete = new Post();
        postDelete.setUser_id(1);
        postDelete.setPost_id(8);

        when(postRepository.findAllPosts()).thenReturn(List.of(postDelete));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> postService.deletePost(1, 7));
    }

    @Test
    void deletePost_postIdMatchesButUserIdDifferent() {
        // Arrange
        Post postDelete = new Post();
        postDelete.setUser_id(2);
        postDelete.setPost_id(7);

        when(postRepository.findAllPosts()).thenReturn(List.of(postDelete));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> postService.deletePost(1, 7));
    }

    @Test
    void deletePost_whenPostDoesNotExist() {
        // Arrange
        when(postRepository.findAllPosts()).thenReturn(List.of());

        // Act & Assert
        NotFoundException e = assertThrows(NotFoundException.class, () -> {
            postService.deletePost(19, 70);
        });

        assertNotEquals("No se encontró una publicación con ID 1 para el usuario 1", e.getMessage());
    }
}