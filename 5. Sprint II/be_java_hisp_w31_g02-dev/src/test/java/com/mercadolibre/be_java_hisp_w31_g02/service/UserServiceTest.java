package com.mercadolibre.be_java_hisp_w31_g02.service;

// 1. Static imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// 2. Java standard library
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
// 3. External libraries
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

// 4. Project-specific imports
import com.mercadolibre.be_java_hisp_w31_g02.dto.DeleteUserDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.FollowerCountDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.SubscriptionDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.UserDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.UserFollowersDto;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Subscription;
import com.mercadolibre.be_java_hisp_w31_g02.entity.User;
import com.mercadolibre.be_java_hisp_w31_g02.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w31_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w31_g02.repository.ISubscriptionRepository;
import com.mercadolibre.be_java_hisp_w31_g02.repository.IUserRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @InjectMocks
    private UserService userService;

    private final Integer userId = 99;
    private final Integer userIdToFollow = 101;
    private final Integer userIdDoesNotExist = 102;
    private final Integer newUserId = 103;

    @Test
    public void getAllFollowersOfASeller_verifyOrder_orderIsOkAsc() {
        //Arrange
        List<Subscription> suscriptors = new ArrayList<>();
        Subscription sub = new Subscription();

        sub.setIdSeller(1);
        sub.setIdClient(2);
        suscriptors.add(sub);

        Subscription subDos = new Subscription();
        subDos.setIdSeller(1);
        subDos.setIdClient(3);
        suscriptors.add(subDos);

        User seller = new User();
        seller.setUserId(1);
        seller.setPublications(new ArrayList<>());
        seller.setUserName("Nico");

        User client = new User();
        client.setUserId(2);
        client.setPublications(new ArrayList<>());
        client.setUserName("Juansito");

        User clientDos = new User();
        clientDos.setUserId(3);
        clientDos.setPublications(new ArrayList<>());
        clientDos.setUserName("Mateo");


        List<User> users = new ArrayList<>();
        users.add(seller);
        users.add(client);
        users.add(clientDos);

        when(userRepository.getUsers()).thenReturn(users);
        when(subscriptionRepository.getAllFollowersOfASeller(1)).thenReturn(suscriptors);
        when(userRepository.findUserById(1)).thenReturn(Optional.of(seller));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(client));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(clientDos));

        List<UserDto> followersExpected = new ArrayList<>();
        followersExpected.add(new UserDto(client));
        followersExpected.add(new UserDto(clientDos));

        UserFollowersDto expected = new UserFollowersDto();
        expected.setUserId(1);
        expected.setUserName("Nico");
        expected.setFollowers(followersExpected);


        //Act
        UserFollowersDto result = userService.getAllFollowersOfASeller(1, "name_asc");


        //Asserts
        assertEquals(expected.getUserId(), result.getUserId());
        assertEquals(expected.getFollowers().size(), result.getFollowers().size());
        assertEquals("Juansito", result.getFollowers().get(0).getUserName());
        assertEquals("Mateo", result.getFollowers().get(1).getUserName());
    }

    @Test
    public void getAllFollowersOfASeller_verifyOrder_orderIsOkDesc() {
        //Arrange
        List<Subscription> suscriptors = new ArrayList<>();
        Subscription sub = new Subscription();

        sub.setIdSeller(1);
        sub.setIdClient(2);
        suscriptors.add(sub);

        Subscription subDos = new Subscription();
        subDos.setIdSeller(1);
        subDos.setIdClient(3);
        suscriptors.add(subDos);

        User seller = new User();
        seller.setUserId(1);
        seller.setPublications(new ArrayList<>());
        seller.setUserName("Nico");

        User client = new User();
        client.setUserId(2);
        client.setPublications(new ArrayList<>());
        client.setUserName("Juansito");

        User clientDos = new User();
        clientDos.setUserId(3);
        clientDos.setPublications(new ArrayList<>());
        clientDos.setUserName("Mateo");


        List<User> users = new ArrayList<>();
        users.add(seller);
        users.add(client);
        users.add(clientDos);

        when(userRepository.getUsers()).thenReturn(users);
        when(subscriptionRepository.getAllFollowersOfASeller(1)).thenReturn(suscriptors);
        when(userRepository.findUserById(1)).thenReturn(Optional.of(seller));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(client));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(clientDos));

        List<UserDto> followersExpected = new ArrayList<>();
        followersExpected.add(new UserDto(client));
        followersExpected.add(new UserDto(clientDos));

        UserFollowersDto expected = new UserFollowersDto();
        expected.setUserId(1);
        expected.setUserName("Nico");
        expected.setFollowers(followersExpected);


        //Act
        UserFollowersDto result = userService.getAllFollowersOfASeller(1, "name_desc");


        //Asserts
        assertEquals(expected.getUserId(), result.getUserId());
        assertEquals(expected.getFollowers().size(), result.getFollowers().size());
        assertEquals("Mateo", result.getFollowers().get(0).getUserName());
        assertEquals("Juansito", result.getFollowers().get(1).getUserName());
    }

    @Test
    public void getAllFollowersOfASeller_verifyOrder_continueOk() {
        //Arrange
        List<Subscription> suscriptors = new ArrayList<>();
        Subscription sub = new Subscription();

        sub.setIdSeller(1);
        sub.setIdClient(2);
        suscriptors.add(sub);

        Subscription subDos = new Subscription();
        subDos.setIdSeller(1);
        subDos.setIdClient(3);
        suscriptors.add(subDos);

        User seller = new User();
        seller.setUserId(1);
        seller.setPublications(new ArrayList<>());
        seller.setUserName("Nico");

        User client = new User();
        client.setUserId(2);
        client.setPublications(new ArrayList<>());
        client.setUserName("Juansito");

        User clientDos = new User();
        clientDos.setUserId(3);
        clientDos.setPublications(new ArrayList<>());
        clientDos.setUserName("Mateo");


        List<User> users = new ArrayList<>();
        users.add(seller);
        users.add(client);
        users.add(clientDos);

        when(userRepository.getUsers()).thenReturn(users);
        when(subscriptionRepository.getAllFollowersOfASeller(1)).thenReturn(suscriptors);
        when(userRepository.findUserById(1)).thenReturn(Optional.of(seller));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(client));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(clientDos));

        List<UserDto> followersExpected = new ArrayList<>();
        followersExpected.add(new UserDto(client));
        followersExpected.add(new UserDto(clientDos));

        UserFollowersDto expected = new UserFollowersDto();
        expected.setUserId(1);
        expected.setUserName("Nico");
        expected.setFollowers(followersExpected);


        //Act
        UserFollowersDto result = userService.getAllFollowersOfASeller(1, "name_asc");


        //Asserts
        assertEquals(expected.getUserId(), result.getUserId());
        assertEquals(2, result.getFollowers().size());
    }

    @Test
    public void getAllFollowersOfASeller_verifyOrder_throwsNotFoundParam() {
        //Arrange
        List<Subscription> suscriptors = new ArrayList<>();
        Subscription sub = new Subscription();

        sub.setIdSeller(1);
        sub.setIdClient(2);
        suscriptors.add(sub);

        Subscription subDos = new Subscription();
        subDos.setIdSeller(1);
        subDos.setIdClient(3);
        suscriptors.add(subDos);

        User seller = new User();
        seller.setUserId(1);
        seller.setPublications(new ArrayList<>());
        seller.setUserName("Nico");

        User client = new User();
        client.setUserId(2);
        client.setPublications(new ArrayList<>());
        client.setUserName("Juansito");

        User clientDos = new User();
        clientDos.setUserId(3);
        clientDos.setPublications(new ArrayList<>());
        clientDos.setUserName("Mateo");


        List<User> users = new ArrayList<>();
        users.add(seller);
        users.add(client);
        users.add(clientDos);

        when(userRepository.getUsers()).thenReturn(users);
        when(subscriptionRepository.getAllFollowersOfASeller(1)).thenReturn(suscriptors);
        when(userRepository.findUserById(1)).thenReturn(Optional.of(seller));
        when(userRepository.findUserById(2)).thenReturn(Optional.of(client));
        when(userRepository.findUserById(3)).thenReturn(Optional.of(clientDos));


        List<UserDto> followersExpected = new ArrayList<>();
        followersExpected.add(new UserDto(client));
        followersExpected.add(new UserDto(clientDos));

        UserFollowersDto expected = new UserFollowersDto();
        expected.setUserId(1);
        expected.setUserName("Nico");
        expected.setFollowers(followersExpected);


        //Act
        NotFoundException result = assertThrows(NotFoundException.class,
                () -> userService.getAllFollowersOfASeller(1, ""));


        //Asserts
        assertEquals("Order not exists", result.getMessage());
    }

    @Test
    void subscribeUserToUser_TryToRegisterAFollowerRelation_ThrowExceptionUserNotFound(){

        // Arrange
        when(userRepository.existUser(userIdToFollow)).thenReturn(true);

        // Act
        NotFoundException exception = assertThrows(
            NotFoundException.class, () -> userService.subscribeUserToUser(userIdDoesNotExist, userIdToFollow)
        );

        // Assert
        assertEquals("User not registered", exception.getMessage());
    }

    @Test
    void subscribeUserToUser_TryToRegisterAFollowerRelation_ThrowExceptionSellerNotFound(){

        // Arrange
        when(userRepository.existUser(userId)).thenReturn(true);

        // Act
        NotFoundException exception = assertThrows(
            NotFoundException.class, () -> userService.subscribeUserToUser(userId, userIdDoesNotExist)
        );

        // Assert
        assertEquals("Seller not registered", exception.getMessage());
    }

    @Test
    void subscribeUserToUser_TryToRegisterAFollowerRelation_ThrowExceptionUserCanNotFollowHimself(){

        // Arrange
        when(userRepository.existUser(userId)).thenReturn(true);
        
        // Act
        ConflictException exception = assertThrows(
            ConflictException.class, () -> userService.subscribeUserToUser(userId, userId)
        );

        // Assert
        assertEquals("User cannot follow himself.", exception.getMessage());
    }

    @Test
    void subscribeUserToUser_TryToRegisterAFollowerRelation_ThrowExceptionTheRelationAlreadyExist(){

        // Arrange
        when(userRepository.existUser(userId)).thenReturn(true);
        when(userRepository.existUser(userIdToFollow)).thenReturn(true);
        when(subscriptionRepository.existRelationBetweenUsers(userId, userIdToFollow)).thenReturn(true);

        // Act
        ConflictException exception = assertThrows(
            ConflictException.class, () -> userService.subscribeUserToUser(userId, userIdToFollow)
        );

        // Assert
        assertEquals("The user already follows the seller", exception.getMessage());
    }

    @Test
    void subscribeUserToUser_TryToRegisterAFollowerRelation_RegisterAValidRelationBetweenClientAndSeleer(){

        // Arrange
        when(userRepository.existUser(userId)).thenReturn(true);
        when(userRepository.existUser(newUserId)).thenReturn(true);
        SubscriptionDto subscriptionDto;

        // Act
        subscriptionDto = userService.subscribeUserToUser(userId, newUserId);

        // Assert
        assertNotNull(subscriptionDto);
    }

    @Test
    void getFollowersCountById_shouldReturnCorrectFollowerCount() {
        // Arrange
        User mockUser = new User();
        mockUser.setUserId(userId);
        mockUser.setUserName("Marcos");

        List<Subscription> mockSubscriptions = Arrays.asList(
                new Subscription(99, 10),  // follower 10 follow seller 1
                new Subscription(99, 11),
                new Subscription(99, 12)
        );

        when(userRepository.findUserById(userId)).thenReturn(Optional.of(mockUser));
        when(subscriptionRepository.listFollowerById(userId)).thenReturn(mockSubscriptions);

        // Act
        FollowerCountDto response = userService.getFollowersCountById(userId);

        // Assert
        assertEquals(99, response.getUser_id());
        assertEquals("Marcos", response.getUser_name());
        assertEquals(3, response.getFollowers_count());
    }

    @Test
    @DisplayName("Unfollow OK - user-seller exist and remove follow")
    void unfollowUser_userToUnfollowExist_shouldReturnSuccessMessage() {
        //Arrage
        Integer userId = 1;
        Integer unfollowSellerId = 2;

        User user = new User(userId, "buyer", new ArrayList<>());
        User seller = new User(unfollowSellerId, "seller", new ArrayList<>());
        Subscription subscription = new Subscription(unfollowSellerId, userId);

        when(userRepository.findUserById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findUserById(unfollowSellerId)).thenReturn(Optional.of(seller));
        when(subscriptionRepository.findFollowerById(userId, unfollowSellerId)).thenReturn(Optional.of(subscription));

        //Act
        DeleteUserDto result = userService.unfollowUser(userId, unfollowSellerId);

        //Assert
        assertEquals("The ID(1) follower of the ID(2) seller has been removed.", result.getMessage());
        verify(subscriptionRepository).deleteFollower(subscription);
    }

    @Test
    @DisplayName("Unfollow - user not exist")
    void unfollowUser_userNotExist_returnNotFoundExceptionMessage(){
        //Arrage
        Integer userId = 1;
        Integer unfollowSellerId = 2;
        when(userRepository.findUserById(userId)).thenReturn(Optional.empty());

        //Act
        NotFoundException result = assertThrows(NotFoundException.class, () -> userService.unfollowUser(userId, unfollowSellerId));

        //Assert
        assertEquals("The user(1) does not exist", result.getMessage());
    }

    @Test
    @DisplayName(" Unfollow - seller not exist")
    void unfollowUser_sellerNotExist_returnNotFoundExceptionMessage(){
        //Arrage
        Integer userId = 1;
        Integer unfollowSellerId = 2;
        User user = new User(userId, "buyer", new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findUserById(unfollowSellerId)).thenReturn(Optional.empty());

        //Act
        NotFoundException result = assertThrows(NotFoundException.class, ()-> userService.unfollowUser(userId, unfollowSellerId));

        //Assert
        assertEquals("The user(2) does not exist", result.getMessage());
    } 

    @Test
    @DisplayName("Unfollow - follow not exist")
    void unfollowUser_userNotFollowSeller_notFoundExceptionMessage(){
        //Arrange
        Integer userId = 1;
        Integer unfollowSellerId = 2;
        User user = new User(userId, "buyer", new ArrayList<>());
        User seller = new User(unfollowSellerId,"seller", new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findUserById(unfollowSellerId)).thenReturn(Optional.of(seller));

        //Act
        NotFoundException result = assertThrows(NotFoundException.class, ()-> userService.unfollowUser(userId, unfollowSellerId));

        //Assert
        assertEquals("User(1) does not follow user(2)", result.getMessage());
    }
}