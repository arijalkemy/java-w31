package com.mercadolibre.melifrescosg9w31.auth;

import com.mercadolibre.melifrescosg9w31.dtos.request.AuthenticationRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.RegisterRepRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.RegisterRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.AuthenticationResponse;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.repository.*;
import com.mercadolibre.melifrescosg9w31.service.AuthenticationService;
import com.mercadolibre.melifrescosg9w31.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AuthenticationServiceTest {

    @Mock
    private IUserAccountRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private IWarehouseRepRepository warehouseRepRepository;
    @Mock
    private IBuyerRepository buyerRepository;
    @Mock
    private ISellerRepository sellerRepository;
    @Mock
    private IWarehouseRepository warehouseRepository;

    @InjectMocks
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register_shouldRegisterBuyerSuccessfully() {
        RegisterRequest request = new RegisterRequest("buyer", "pass", Role.BUYER);
        when(passwordEncoder.encode("pass")).thenReturn("encoded");
        when(jwtService.generateToken(any())).thenReturn("token");

        AuthenticationResponse response = authenticationService.register(request);

        assertEquals("token", response.getToken());
        verify(userRepository).save(any(UserAccount.class));
        verify(buyerRepository).save(any(Buyer.class));
        verify(jwtService).generateToken(any(UserAccount.class));
    }

    @Test
    void register_shouldRegisterSellerSuccessfully() {
        RegisterRequest request = new RegisterRequest("seller", "pass", Role.SELLER);
        when(passwordEncoder.encode("pass")).thenReturn("encoded");
        when(jwtService.generateToken(any())).thenReturn("token");

        AuthenticationResponse response = authenticationService.register(request);

        assertEquals("token", response.getToken());
        verify(userRepository).save(any(UserAccount.class));
        verify(sellerRepository).save(any(Seller.class));
        verify(jwtService).generateToken(any(UserAccount.class));
    }

    @Test
    void register_shouldThrowExceptionForInvalidRole() {
        RegisterRequest request = new RegisterRequest("invalid", "pass", Role.WAREHOUSE_REP);
        when(passwordEncoder.encode("pass")).thenReturn("encoded");

        assertThrows(BadRequestException.class, () -> authenticationService.register(request));
        verify(userRepository).save(any(UserAccount.class));
    }

    @Test
    void registerRep_shouldRegisterWarehouseRepSuccessfully() {
        RegisterRepRequest request = new RegisterRepRequest("rep", "pass", 1);
        Warehouse warehouse = new Warehouse();
        when(passwordEncoder.encode("pass")).thenReturn("encoded");
        when(warehouseRepository.findByWarehouseCode(1)).thenReturn(Optional.of(warehouse));
        when(jwtService.generateToken(any())).thenReturn("token");

        AuthenticationResponse response = authenticationService.registerRep(request);

        assertEquals("token", response.getToken());
        verify(userRepository).save(any(UserAccount.class));
        verify(warehouseRepRepository).save(any(WarehouseRep.class));
        verify(jwtService).generateToken(any(UserAccount.class));
    }

    @Test
    void registerRep_shouldThrowExceptionForInvalidWarehouse() {
        RegisterRepRequest request = new RegisterRepRequest("rep", "pass", null);
        when(passwordEncoder.encode("pass")).thenReturn("encoded");
        when(warehouseRepository.findByWarehouseCode(null)).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> authenticationService.registerRep(request));
        verify(userRepository).save(any(UserAccount.class));
    }

    @Test
    void authenticate_shouldAuthenticateSuccessfully() {
        AuthenticationRequest request = new AuthenticationRequest("user", "pass");
        UserAccount user = UserAccount.builder().userName("user").password("encoded").role(Role.BUYER).build();
        when(userRepository.findByUserName("user")).thenReturn(Optional.of(user));
        when(jwtService.generateToken(user)).thenReturn("token");

        AuthenticationResponse response = authenticationService.authenticate(request);

        assertEquals("token", response.getToken());
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(jwtService).generateToken(user);
    }

    @Test
    void authenticate_shouldThrowExceptionForNonExistentUser() {
        AuthenticationRequest request = new AuthenticationRequest("user", "pass");
        when(userRepository.findByUserName("user")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> authenticationService.authenticate(request));
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }
}