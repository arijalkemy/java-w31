package com.bootcamp.be_java_hisp_w31_g09.service;

import com.bootcamp.be_java_hisp_w31_g09.dto.*;
import com.bootcamp.be_java_hisp_w31_g09.entity.Post;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;
import com.bootcamp.be_java_hisp_w31_g09.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w31_g09.repository.SellerRepository;
import com.bootcamp.be_java_hisp_w31_g09.utils.CustomFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private SellerRepository sellerRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private ProductServiceImpl productService;

    private static final Integer ID = 1;
    private static final String ORDER_DESC = "date_desc";
    private static final String ORDER_ASC = "date_asc";
    private static final String ORDER_INVALID = "invalid";
    private static final String ORDER_NULL = null;

    private UserListDTO emptyUserListDto;

    @BeforeEach
    void setUp(){
        emptyUserListDto = new UserListDTO();
        emptyUserListDto.setUserList(new ArrayList<>());
        when(userService.searchSellersFollowed(ID)).thenReturn(emptyUserListDto);
    }

    @Test
    @DisplayName("T-0005 Order Valid Date_Desc")
    void testOrderValidDate_Desc(){
        assertDoesNotThrow(()->productService.getFollowedPostsOrder(ID,ORDER_DESC));
    }
    @Test
    @DisplayName("T-0005 Order Valid Date_Asc")
    void testOrderValidDate_Asc(){
        assertDoesNotThrow(()->productService.getFollowedPostsOrder(ID,ORDER_ASC));
    }
    @Test
    @DisplayName("T-0005 Order Invalid")
    void testOrderInvalid(){
        //Act
        BadRequestException exception = assertThrows(BadRequestException.class,
                ()->productService.getFollowedPostsOrder(ID,ORDER_INVALID));

        //Assert
        assertEquals("Ese orden no es valido.",exception.getMessage());
    }

    @Test
    @DisplayName("T-0005 Order null")
    void testOrderNull(){
        assertDoesNotThrow(()->productService.getFollowedPostsOrder(ID,ORDER_NULL));
    }


    private void mockSellerWithPosts(List<Post> postList) {
        Seller seller = new Seller(ID, "Vendedor",postList);

        UserDTO followedSellerDTO = new UserDTO(ID, "Vendedor");
        UserListDTO followedList = new UserListDTO(1,"Nombre X", List.of(followedSellerDTO));
        when(userService.searchSellersFollowed(ID)).thenReturn(followedList);

        when(sellerRepository.getAll()).thenReturn(List.of(seller));
    }

    @Test
    @DisplayName("T-0006 Correct Asc Order")
    void testVerifyCorrectAscOrder(){
        //Arrange
        mockSellerWithPosts(CustomFactory.createPosts());

        //Act
        UserPostsResponseDTO response = productService.getFollowedPostsOrder(ID,ORDER_ASC);
        List<PromoPostDTO> posts = response.getPosts();

        //Assert
        assertEquals(2, posts.size());
        assertTrue(posts.get(0).getDate().isBefore(posts.get(1).getDate()));
    }

    @Test
    @DisplayName("T-0006 Correct Desc Order")
    void testVerifyCorrectDescOrder(){
        //Arrange
        mockSellerWithPosts(CustomFactory.createPosts());

        // Act
        UserPostsResponseDTO response = productService.getFollowedPostsOrder(ID, ORDER_DESC);
        List<PromoPostDTO> posts = response.getPosts();

        // Assert
        assertEquals(2, posts.size());
        assertTrue(posts.get(1).getDate().isBefore(posts.get(0).getDate()));
    }

    @Test
    @DisplayName("T-0006 Correct Asc Order Date Equals")
    void testVerifyCorrectAscOrderDateEquals(){
        //Arrange
        mockSellerWithPosts(CustomFactory.createPostsDateEqueals());

        //Act
        UserPostsResponseDTO response = productService.getFollowedPostsOrder(ID, ORDER_ASC);
        List<PromoPostDTO> posts = response.getPosts();

        //Assert
        assertEquals(2, posts.size());
        assertTrue(posts.get(0).getDate().isEqual(posts.get(1).getDate()));
    }

    @Test
    @DisplayName("T-0006 Correct Desc Order Date Equals")
    void testVerifyCorrectDescOrderDateEquals(){
        //Arrange
        mockSellerWithPosts(CustomFactory.createPosts());

        // Act
        UserPostsResponseDTO response = productService.getFollowedPostsOrder(ID, ORDER_DESC);
        List<PromoPostDTO> posts = response.getPosts();

        // Assert
        assertEquals(2, posts.size());
        assertTrue(posts.get(1).getDate().isBefore(posts.get(0).getDate()));
    }
    @Test
    @DisplayName("T-0006 Correct Asc Order Post Empty")
    void testVerifyCorrectAscOrderEmpty(){
        //Arrange
        mockSellerWithPosts(CustomFactory.createPostsEmpty());

        //Act
        UserPostsResponseDTO response = productService.getFollowedPostsOrder(ID, ORDER_ASC);
        List<PromoPostDTO> posts = response.getPosts();

        //Assert
        assertEquals(0, posts.size());
    }

    @Test
    @DisplayName("T-0006 Correct Desc Order Empty")
    void testVerifyCorrectDescOrderEmpty(){
        //Arrange
        mockSellerWithPosts(CustomFactory.createPostsEmpty());

        // Act
        UserPostsResponseDTO response = productService.getFollowedPostsOrder(ID, ORDER_DESC);
        List<PromoPostDTO> posts = response.getPosts();

        // Assert
        assertEquals(0, posts.size());
    }

    @Test
    @DisplayName("T-0008 - Test getFollowedPostsOrder with default last two weeks posts")
    public void testGetFollowedPostsLastTwoWeeks() {
        // Arrange
        mockSellerWithPosts(CustomFactory.createPosts());
        //Act
        UserPostsResponseDTO obtenedRespone = productService.getFollowedPostsOrder(ID, null);
        // Assert
        verify(sellerRepository, Mockito.times(1)).getAll();
        Assertions.assertNotNull(obtenedRespone);
        Assertions.assertEquals(2, obtenedRespone.getPosts().size());
    }
}
