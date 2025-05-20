package com.bootcamp.be_java_hisp_w31_g09.service;
import com.bootcamp.be_java_hisp_w31_g09.dto.*;
import com.bootcamp.be_java_hisp_w31_g09.entity.Buyer;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;
import com.bootcamp.be_java_hisp_w31_g09.dto.UserListDTO;
import com.bootcamp.be_java_hisp_w31_g09.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w31_g09.repository.*;
import com.bootcamp.be_java_hisp_w31_g09.utils.CustomFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.bootcamp.be_java_hisp_w31_g09.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private BuyerRepository buyerRepository;

    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private Integer sellerId;
    private String sellerName;
    private Buyer buyer;


    @BeforeEach
    public void setUp() {
        sellerId = 6;
        sellerName = "Sofia";
        buyer = new Buyer(10, "Alice", List.of(1,2,3));
    }

    @Test
    @DisplayName("Not Found Seller")
    public void testSellerNotFound(){
        Integer invalidId = 999;
        Optional<String> order = Optional.of("name_asc");
        when(sellerRepository.getUsernameByID(invalidId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,
                () -> userService.getSellerFollowersOrdered(invalidId, order));
    }

    @Test
    @DisplayName("Not Found Buyer")
    public void testBuyerNotFound(){
        Integer invalidId = 999;
        Optional<String> order = Optional.of("name_asc");
        when(buyerRepository.findById(invalidId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,
                () -> userService.searchSellersFollowedOrdered(invalidId, order));
    }

    @Test
    @DisplayName("Followers asc order")
    public void testSellerFollowersByOrderAsc() {
        when(sellerRepository.getUsernameByID(sellerId)).thenReturn(Optional.of(sellerName));
        List<Buyer> followers = CustomFactory.followersList();
        when(buyerRepository.getSellerFollowers(sellerId)).thenReturn(followers);

        UserListDTO expected = CustomFactory.twoFollowersAscResponse(sellerId, sellerName);
        UserListDTO result = userService.getSellerFollowersOrdered(sellerId, Optional.of("name_asc"));

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Followrs desc order")
    public void testSellerFollowersByOrderDesc() {
        when(sellerRepository.getUsernameByID(sellerId)).thenReturn(Optional.of(sellerName));
        List<Buyer> followers = CustomFactory.followersList();
        when(buyerRepository.getSellerFollowers(sellerId)).thenReturn(followers);

        UserListDTO expected = CustomFactory.twoFollowersAscResponse(sellerId, sellerName);
        UserListDTO result = userService.getSellerFollowersOrdered(sellerId, Optional.of("name_asc"));

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Followed asc order")
    public void testBuyerFollowedByOrderAsc(){
        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));
        List<Seller> followed = CustomFactory.followedList();
        when(sellerRepository.findAllById(buyer.getFollowed())).thenReturn(followed);

        UserListDTO expected = CustomFactory.threeFollowedAscResponse(buyer.getId(), buyer.getName());
        UserListDTO result = userService.searchSellersFollowedOrdered(buyer.getId(), Optional.of("name_asc"));

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Followed desc order")
    public void testBuyerFollowedByOrderDesc(){
        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));
        List<Seller> followed = CustomFactory.followedList();
        when(sellerRepository.findAllById(buyer.getFollowed())).thenReturn(followed);

        UserListDTO expected = CustomFactory.threeFollowedDescResponse(buyer.getId(), buyer.getName());
        UserListDTO result = userService.searchSellersFollowedOrdered(buyer.getId(), Optional.of("name_desc"));

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Followed no order")
    public void testBuyerFollowedNoOrder(){
        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));
        List<Seller> followed = CustomFactory.followedList();
        when(sellerRepository.findAllById(buyer.getFollowed())).thenReturn(followed);

        UserListDTO expected = CustomFactory.threeFollowedNoOrderResponse(buyer.getId(), buyer.getName());
        UserListDTO result = userService.searchSellersFollowedOrdered(buyer.getId(), Optional.empty());

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Followers no order")
    public void testSellerFollowersNoOrder() {
        when(sellerRepository.getUsernameByID(sellerId)).thenReturn(Optional.of(sellerName));
        List<Buyer> followers = CustomFactory.followersList();
        when(buyerRepository.getSellerFollowers(sellerId)).thenReturn(followers);

        UserListDTO expected = CustomFactory.twoFollowersAscResponse(sellerId, sellerName);
        UserListDTO result = userService.getSellerFollowersOrdered(sellerId, Optional.empty());

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Happy Path followers ordered Asc")
    public void testOrderFollowersExistsNameAsc(){
        //Arrange
        Integer buyerId = 1;

        Optional<String> order = "name_asc".describeConstable();

        Buyer buyer = CustomFactory.generateBuyer();

        List<Integer> sellersIds = Arrays.asList(2,3);

        List<Seller> sellers = CustomFactory.generateSellersOrderedAsc();

        when(buyerRepository.findById(buyerId)).thenReturn(Optional.of(buyer));

        when(sellerRepository.findAllById(sellersIds)).thenReturn(sellers);

        //Act + Assert
        assertDoesNotThrow(() -> userService.searchSellersFollowedOrdered(buyerId, order));
    }

    @Test
    @DisplayName("Happy Path followers ordered Desc")
    public void testOrderFollowersExistsNameDesc(){
        //Arrange
        Integer buyerId = 1;

        Optional<String> order = "name_desc".describeConstable();

        Buyer buyer = CustomFactory.generateBuyer();

        List<Integer> sellersIds = Arrays.asList(2,3);

        List<Seller> sellers = CustomFactory.generateSellersOrderedDesc();

        when(buyerRepository.findById(buyerId)).thenReturn(Optional.of(buyer));

        when(sellerRepository.findAllById(sellersIds)).thenReturn(sellers);

        //Act + Assert
        assertDoesNotThrow(() -> userService.searchSellersFollowedOrdered(buyerId, order));
    }

    @Test
    @DisplayName("Invalid Order followers")
    public void testOrderFollowersNotExists(){
        //Arrange
        Integer buyerId = 1;

        Optional<String> order = "".describeConstable();

        Buyer buyer = CustomFactory.generateBuyer();

        when(buyerRepository.findById(buyerId)).thenReturn(Optional.of(buyer));

        //Act + Assert
        assertThrows(BadRequestException.class, () -> userService.searchSellersFollowedOrdered(buyerId, order));
    }

    @Test
    @DisplayName("Empty Order followers")
    public void testOrderFollowersEmpty(){
        //Arrange
        Integer buyerId = 1;

        Optional<String> order = Optional.empty();

        Buyer buyer = CustomFactory.generateBuyer();

        List<Integer> sellersIds = Arrays.asList(2,3);

        List<Seller> sellers = CustomFactory.generateSellersOrderedAsc();

        when(buyerRepository.findById(buyerId)).thenReturn(Optional.of(buyer));

        when(sellerRepository.findAllById(sellersIds)).thenReturn(sellers);

        //Act + Assert
        assertDoesNotThrow(() -> userService.searchSellersFollowedOrdered(buyerId, order));
    }

    @Test
    @DisplayName("Happy Path followed ordered Asc")
    public void testOrderFollowedExistsNameAsc(){
        //Arrange
        Integer sellerId = 1;

        Optional<String> order = "name_asc".describeConstable();

        Seller seller = CustomFactory.generateSeller();

        List<Buyer> buyers = CustomFactory.generateBuyersOrderedAsc();

        when(sellerRepository.getUsernameByID(sellerId)).thenReturn(Optional.of(seller.getName()));

        when(buyerRepository.getSellerFollowers(sellerId)).thenReturn(buyers);

        //Act + Assert
        assertDoesNotThrow(() -> userService.getSellerFollowersOrdered(sellerId, order));
    }

    @Test
    @DisplayName("Happy Path followed ordered Desc")
    public void testOrderFollowedExistsNameDesc(){
        //Arrange
        Integer sellerId = 1;

        Optional<String> order = "name_desc".describeConstable();

        Seller seller = CustomFactory.generateSeller();

        List<Buyer> buyers = CustomFactory.generateBuyersOrderedDesc();

        when(sellerRepository.getUsernameByID(sellerId)).thenReturn(Optional.of(seller.getName()));

        when(buyerRepository.getSellerFollowers(sellerId)).thenReturn(buyers);

        //Act + Assert
        assertDoesNotThrow(() -> userService.getSellerFollowersOrdered(sellerId, order));
    }

    @Test
    @DisplayName("Invalid Order followed")
    public void testOrderFollowedNotExists(){
        //Arrange
        Integer sellerId = 1;

        Optional<String> order = "".describeConstable();

        Seller seller = CustomFactory.generateSeller();

        when(sellerRepository.getUsernameByID(sellerId)).thenReturn(Optional.of(seller.getName()));

        //Act + Assert
        assertThrows(BadRequestException.class, () -> userService.getSellerFollowersOrdered(sellerId, order));
    }

    @Test
    @DisplayName("Empty Order followed")
    public void testOrderFollowedEmpty(){
        //Arrange
        Integer sellerId = 1;

        Optional<String> order = Optional.empty();

        Seller seller = CustomFactory.generateSeller();

        List<Buyer> buyers = CustomFactory.generateBuyersOrderedAsc();

        when(sellerRepository.getUsernameByID(sellerId)).thenReturn(Optional.of(seller.getName()));

        when(buyerRepository.getSellerFollowers(sellerId)).thenReturn(buyers);

        //Act + Assert
        assertDoesNotThrow(() -> userService.getSellerFollowersOrdered(sellerId, order));
    }

    @Test
    @DisplayName("Happy Path follow")
    void testBuyerFollowsExistingSeller() {
        // Arrange
        int sellerId = 1;
        int buyerId = 12;

        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(CustomFactory.getNewSeller()));
        when(buyerRepository.findById(buyerId)).thenReturn(Optional.of(CustomFactory.getNewBuyer()));

        // Act
        ResponseMessageDTO response = userService.follow(buyerId, sellerId);

        // Assert
        assertEquals("Vendedor seguido con éxito", response.getMessage());
    }

    @Test
    @DisplayName("Not Found Seller follow")
    void testBuyerFollowsNonExistingSeller() {
        // Arrange
        int sellerId = 1;
        int buyerId = 12;

        when(sellerRepository.findById(sellerId)).thenReturn(Optional.empty());
        when(buyerRepository.findById(buyerId)).thenReturn(Optional.of(CustomFactory.getNewBuyer()));

        // Act + Assert
        assertThrows(NotFoundException.class, () -> userService.follow(buyerId, sellerId));
    }

    @Test
    @DisplayName("Already follows")
    void testBuyerFollowsAlreadyFollowedSeller() {
        // Arrange
        Buyer buyer = CustomFactory.getNewBuyer();
        Seller seller = CustomFactory.getNewSeller();
        int sellerId = 4;

        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(seller));

        // Act + Assert
        assertThrows(BadRequestException.class, () -> userService.follow(buyer.getId(), sellerId));
    }

    @Test
    @DisplayName("Not Found Buyer follow")
    void testNonExistentBuyerFollowsSeller() {
        // Arrange
        int nonExistentBuyerId = 999;
        int sellerId = 1;

        when(buyerRepository.findById(nonExistentBuyerId)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(NotFoundException.class, () -> userService.follow(nonExistentBuyerId, sellerId));
    }

    @Test
    @DisplayName("Happy Path unfollow")
    void testBuyerUnfollowsExistingSeller() {
        // Arrange
        Buyer buyer = CustomFactory.getNewBuyer();
        Seller seller = CustomFactory.getNewSeller();
        int sellerId = 5;

        buyer.getFollowed().add(sellerId);

        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(seller));

        // Act
        ResponseMessageDTO response = userService.unfollow(buyer.getId(), sellerId);

        // Assert
        assertEquals("Se ha dejado de seguir satisfactoriamente", response.getMessage());
        verify(buyerRepository).findById(buyer.getId());
        verify(sellerRepository).findById(sellerId);
    }

    @Test
    @DisplayName("Not Found seller unfollow")
    void testBuyerUnfollowsNonExistingSeller() {
        // Arrange
        Buyer buyer = CustomFactory.getNewBuyer();
        int nonExistentSellerId = 999;

        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));
        when(sellerRepository.findById(nonExistentSellerId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> userService.unfollow(buyer.getId(), nonExistentSellerId));
    }

    @Test
    @DisplayName("Not Found buyer unfollow")
    void testNonExistentBuyerUnfollowsSeller() {
        // Arrange
        int nonExistentBuyerId = 999;
        int sellerId = 1;

        when(buyerRepository.findById(nonExistentBuyerId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> userService.unfollow(nonExistentBuyerId, sellerId));
    }

    @Test
    @DisplayName("Not following unfollow")
    void testBuyerUnfollowsSellerNotFollowed() {
        // Arrange
        Buyer buyer = CustomFactory.getNewBuyer();
        Seller seller = CustomFactory.getNewSeller();
        int sellerId = seller.getId();

        buyer.getFollowed().clear();

        when(buyerRepository.findById(buyer.getId())).thenReturn(Optional.of(buyer));
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(seller));

        // Act + Assert
        assertThrows(NotFoundException.class, () -> userService.unfollow(buyer.getId(), sellerId));
    }


    @Test
    @DisplayName("Happy Path get followers")
    void testGetFollowersCount() {
        //Arrange
        Integer userId = 2;
        Seller seller = CustomFactory.generateSeller();
        List<Buyer> buyers = CustomFactory.generateBuyers();

        when(sellerRepository.findById(userId)).thenReturn(Optional.of(seller));
        when(buyerRepository.findAll()).thenReturn(buyers);

        // Act
        ResponseFollowersCountDTO result = userService.getFollowersCount(userId);

        // Assert
        assertEquals(userId, result.getUserId());
        assertEquals("Juan", result.getUserName());
        assertEquals(1, result.getFollowersCount());

        verify(sellerRepository).findById(userId);
        verify(buyerRepository).findAll();
    }

    @Test
    @DisplayName("Not Found get followers")
    void testGetFollowersCount_UserNotFound() {
        // Arrange
        Integer userId = 99;
        when(sellerRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            userService.getFollowersCount(userId);
        });

        verify(sellerRepository).findById(userId);
    }

    @Test
    @DisplayName("No followers get followers")
    void testGetFollowersCount_NoFollowers() {
        // Arrange
        Integer userId = 1;
        Seller seller = new Seller(userId, "Juan", List.of());
        List<Buyer> buyers = List.of(); // Sin seguidores

        when(sellerRepository.findById(userId)).thenReturn(Optional.of(seller));
        when(buyerRepository.findAll()).thenReturn(buyers);

        // Act
        ResponseFollowersCountDTO result = userService.getFollowersCount(userId);

        // Assert
        assertEquals(userId, result.getUserId());
        assertEquals("Juan", result.getUserName());
        assertEquals(0, result.getFollowersCount());
    }

}