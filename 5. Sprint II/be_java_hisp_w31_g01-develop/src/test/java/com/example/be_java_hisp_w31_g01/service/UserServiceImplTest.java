package com.example.be_java_hisp_w31_g01.service;


import com.example.be_java_hisp_w31_g01.dto.FollowedResponseDto;
import com.example.be_java_hisp_w31_g01.dto.FollowerResponseDTO;
import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import com.example.be_java_hisp_w31_g01.exception.BadRequestException;
import com.example.be_java_hisp_w31_g01.exception.NotFoundException;
import com.example.be_java_hisp_w31_g01.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void followSeller_userIdAndUserIdToFollowNotNullOrEqual() {
        // Arrange
        int sellerId = 1;
        int customerId = 101;

        Customer customer = new Customer();
        customer.setUser_id(customerId);
        customer.setFollowed(new ArrayList<>());

        Seller seller = new Seller();
        seller.setUser_id(sellerId);
        seller.setFollowers(new ArrayList<>());

        when(userRepository.findCustomerById(customerId)).thenReturn(customer);
        when(userRepository.findSellerById(sellerId)).thenReturn(seller);

        // Act & Assert
        assertDoesNotThrow(() -> userService.followSeller(customerId, sellerId));
    }

    @Test
    void followSeller_userIdAndUserIdToFollowEquals() {
        // Arrange
        int userId = 1;

        // Act & Assert
        assertThrows(BadRequestException.class, () -> userService.followSeller(userId, userId));
    }

    @Test
    void followSeller_alreadyFollowingThrowsException() {
        // Arrange
        int sellerId = 1;
        int customerId = 101;

        Seller seller = new Seller();
        seller.setUser_id(sellerId);

        Customer customer = new Customer();
        customer.setUser_id(customerId);
        customer.setFollowed(new ArrayList<>());
        customer.getFollowed().add(seller);

        when(userRepository.findCustomerById(customerId)).thenReturn(customer);
        when(userRepository.findSellerById(sellerId)).thenReturn(seller);

        // Act & Assert
        assertThrows(BadRequestException.class, () -> userService.followSeller(customerId, sellerId));
    }

    @Test
    void getFollowers_noFollowersThrowsNotFoundException() {
        // Arrange
        int userId = 1;

        when(userRepository.getAllFollowersById(userId)).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> userService.getFollowers(userId, null));
    }

    @Test
    void countFollowers_returnsCorrectCount() {
        // Arrange
        int userId = 5;
        List<Customer> mockedFollowersList = Arrays.asList(
                new Customer(), new Customer(), new Customer()
        );
        when(userRepository.getAllFollowersById(userId)).thenReturn(mockedFollowersList);

        // Act
        long result = userService.countFollowers(userId);

        // Assert
        assertEquals(3, result);
        verify(userRepository).getAllFollowersById(userId);
    }

    @Test
    void countFollowers_returnsZeroIfNoFollowers() {
        // Arrange
        int userId = 5;
        when(userRepository.getAllFollowersById(userId)).thenReturn(Collections.emptyList());

        // Act
        long result = userService.countFollowers(userId);

        // Assert
        assertEquals(0, result);
        verify(userRepository).getAllFollowersById(userId);
    }

    @Test
    void getFollowers_sortedByNameAsc() {
        // Arrange
        int userId = 1;
        Customer customer1 = new Customer();
        customer1.setUser_id(101);
        customer1.setUser_name("customer01");

        Customer customer2 = new Customer();
        customer2.setUser_id(102);
        customer2.setUser_name("customer02");

        List<Customer> followers = new ArrayList<>(List.of(customer1, customer2));
        Seller seller = new Seller();
        seller.setUser_id(userId);
        seller.setUser_name("seller01");
        seller.setFollowers(followers);

        when(userRepository.getAllFollowersById(userId)).thenReturn(followers);
        when(userRepository.findSellerById(userId)).thenReturn(seller);

        // Act
        FollowerResponseDTO response = userService.getFollowers(userId, "name_asc");

        // Assert
        assertEquals("customer01", response.getFollowers().get(0).getUser_name());
        assertEquals("customer02", response.getFollowers().get(1).getUser_name());
    }

    @Test
    void getFollowers_sortedByNameDesc() {
        // Arrange
        int userId = 1;
        Customer customer1 = new Customer();
        customer1.setUser_id(101);
        customer1.setUser_name("customer01");

        Customer customer2 = new Customer();
        customer2.setUser_id(102);
        customer2.setUser_name("customer02");

        List<Customer> followers = new ArrayList<>(List.of(customer1, customer2));
        Seller seller = new Seller();
        seller.setUser_id(userId);
        seller.setUser_name("seller01");
        seller.setFollowers(followers);

        when(userRepository.getAllFollowersById(userId)).thenReturn(followers);
        when(userRepository.findSellerById(userId)).thenReturn(seller);

        // Act
        FollowerResponseDTO response = userService.getFollowers(userId, "name_desc");

        // Assert
        assertEquals("customer02", response.getFollowers().get(0).getUser_name());
        assertEquals("customer01", response.getFollowers().get(1).getUser_name());
    }

    @Test
    void getFollowers_invalidOrderThrowsBadRequestException() {
        // Arrange
        int userId = 1;

        when(userRepository.getAllFollowersById(userId)).thenReturn(Collections.singletonList(new Customer()));

        // Act & Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowers(userId, "invalid_order"));
    }

    @Test
    void getFollowed_InvalidOrder_ThrowsBadRequestException() {
        //Arrange
        int userId = 1;
        String order = "invalid_order";
        Seller seller1 = new Seller();
        seller1.setUser_id(2);
        seller1.setUser_name("Carlos");

        Seller seller2 = new Seller();
        seller2.setUser_id(3);
        seller2.setUser_name("Ana");

        Customer mockCustomer = new Customer();
        mockCustomer.setUser_id(1);
        mockCustomer.setUser_name("Juan");
        mockCustomer.setFollowed(List.of(seller1, seller2));

        when(userRepository.getAllFollowedById(userId)).thenReturn(List.of(seller1, seller2));

        //Act & Assert
        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> userService.getFollowed(userId, order)
        );
        assertEquals("Parámetro 'order' inválido. Debe ser 'name_asc' o 'name_desc'.", exception.getMessage());
    }

    @Test
    void getFollowed_EmptyFollowedList_ThrowsNotFoundException() {
        // Arrange
        int userId = 1;
        when(userRepository.getAllFollowedById(userId)).thenReturn(Collections.emptyList());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> userService.getFollowed(userId, null)
        );

        assertEquals("El usuario con id " + userId + " no sigue a ningún vendedor.", exception.getMessage());
    }


    @Test
    void getFollowed_OrderAsc_ReturnsListSortedByNameAsc() {
        // Arrange
        int userId = 1;
        String order = "name_asc";
        Seller seller1 = new Seller();
        seller1.setUser_id(2);
        seller1.setUser_name("Carlos");

        Seller seller2 = new Seller();
        seller2.setUser_id(3);
        seller2.setUser_name("Ana");

        Customer mockCustomer = new Customer();
        mockCustomer.setUser_id(1);
        mockCustomer.setUser_name("Juan");
        mockCustomer.setFollowed(List.of(seller2, seller1)); //Desordenado

        when(userRepository.getAllFollowedById(userId)).thenReturn(List.of(seller1, seller2));
        when(userRepository.findCustomerById(userId)).thenReturn(mockCustomer);

        // Act
        FollowedResponseDto result = userService.getFollowed(userId, order);

        // Assert
        List<Seller> resultList = result.getFollowed();
        assertEquals(2, resultList.size());
        assertEquals("Ana", resultList.get(0).getUser_name()); // Ordenado
        assertEquals("Carlos", resultList.get(1).getUser_name());
    }

    @Test
    void getFollowed_OrderDesc_ReturnsListSortedByNameDesc() {
        // Arrange
        int userId = 1;
        String order = "name_desc";
        Seller seller1 = new Seller();
        seller1.setUser_id(2);
        seller1.setUser_name("Carlos");

        Seller seller2 = new Seller();
        seller2.setUser_id(3);
        seller2.setUser_name("Ana");

        Customer mockCustomer = new Customer();
        mockCustomer.setUser_id(1);
        mockCustomer.setUser_name("Juan");
        mockCustomer.setFollowed(List.of(seller2, seller1));

        when(userRepository.getAllFollowedById(userId)).thenReturn(List.of(seller2, seller1));
        when(userRepository.findCustomerById(userId)).thenReturn(mockCustomer);

        // Act
        FollowedResponseDto result = userService.getFollowed(userId, order);

        // Assert
        List<Seller> resultList = result.getFollowed();
        assertEquals(2, resultList.size());
        assertEquals("Carlos", resultList.get(0).getUser_name()); // Orden descendente
        assertEquals("Ana", resultList.get(1).getUser_name());
    }

    @Test
    void user_nameSeller_ValidId_ReturnsUserName() {
        // Arrange
        int userId = 1;
        Seller seller = new Seller();
        seller.setUser_id(1);
        seller.setUser_name("Carlos");
        when(userRepository.findSellerById(userId)).thenReturn(seller);

        // Act
        String result = userService.user_nameSeller(userId);

        // Assert
        assertEquals("Carlos", result);
    }

    @Test
    void Should_unfollowSeller_when_GetACustomerIDAndSellerID() {
        //Arrange
        int customerId = 1;
        int sellerId = 3;
        List<Seller> sellers = new ArrayList<>();
        Customer customer = new Customer();
        Seller seller = new Seller();
        customer.setUser_id(customerId);
        seller.setUser_id(sellerId);
        when(userRepository.findCustomerById(1)).thenReturn(customer);
        when(userRepository.findSellerById(3)).thenReturn(seller);
        sellers.add(seller);
        customer.setFollowed(sellers);

        //Act
        userService.unfollowSeller(customerId, sellerId);

        //Assert
        verify(userRepository).unfollow(customer.getUser_id(), seller.getUser_id());
    }
    @Test
    void Should_throwNotFoundException_when_GetACustomerIDNull() {
        //Arrange
        int customerId = 1;
        int sellerId = 3;
        Customer customer = new Customer();
        Seller seller = new Seller();
        customer.setUser_id(customerId);
        seller.setUser_id(sellerId);
        when(userRepository.findCustomerById(1)).thenReturn(null);
        when(userRepository.findSellerById(3)).thenReturn(seller);

        //Act-Assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.unfollowSeller(customerId, sellerId));
    }
    @Test
    void Should_throwNotFoundException_when_GetASellerIDNull() {
        //Arrange
        int customerId = 1;
        int sellerId = 3;
        Customer customer = new Customer();
        Seller seller = new Seller();
        customer.setUser_id(customerId);
        seller.setUser_id(sellerId);
        when(userRepository.findCustomerById(1)).thenReturn(customer);
        when(userRepository.findSellerById(3)).thenReturn(null);

        //Act-Assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.unfollowSeller(customerId, sellerId));
    }

    @Test
    void Should_throwBadRequestException_when_CustomerDosntFollowSeller() {
        //Arrange
        int customerId = 1;
        int sellerId = 3;
        Customer customer = new Customer();
        Seller seller = new Seller();
        customer.setUser_id(customerId);
        seller.setUser_id(sellerId);
        when(userRepository.findCustomerById(1)).thenReturn(customer);
        when(userRepository.findSellerById(3)).thenReturn(seller);
        List<Seller> sellers = new ArrayList<>();
        customer.setFollowed(sellers);

        //Act-Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.unfollowSeller(customerId, sellerId));
    }
}