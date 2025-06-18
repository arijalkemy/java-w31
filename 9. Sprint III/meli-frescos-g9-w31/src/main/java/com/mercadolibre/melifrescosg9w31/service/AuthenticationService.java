package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.request.AuthenticationRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.RegisterRepRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.RegisterRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.AuthenticationResponse;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserAccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final IWarehouseRepRepository IWarehouseRepRepository;
    private final IBuyerRepository buyerRepository;
    private final ISellerRepository ISellerRepository;
    private final IWarehouseRepository warehouseRepository;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = UserAccount.builder()
                .userName(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        if(userRepository.findByUserName(user.getUsername()).isPresent()) {
            throw new BadRequestException("User already exist.");
        }
        userRepository.save(user);
        if (!registerUserEntity(user, request.getRole())) {
            throw new BadRequestException("User role is not valid.");
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    private boolean registerUserEntity(UserAccount user, Role role) {
        switch (role) {
            case BUYER:
                Buyer buyer = new Buyer();
                buyer.setUser(user);
                buyerRepository.save(buyer);
                break;
            case SELLER:
                Seller seller = new Seller();
                seller.setUser(user);
                ISellerRepository.save(seller);
                break;
            default:
                return false;
        }

        return true;
    }

    public AuthenticationResponse registerRep(RegisterRepRequest request) {
        var user = UserAccount.builder()
                .userName(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.WAREHOUSE_REP)
                .build();

        userRepository.save(user);
        WarehouseRep rep = new WarehouseRep();
        rep.setUser(user);
        rep.setName(request.getUsername());
        Optional<Warehouse> warehouse = warehouseRepository.findByWarehouseCode(request.getWarehouseCode());
        if (warehouse.isEmpty()) {
            throw new BadRequestException("Warehouse code is not valid.");
        }

        rep.setWarehouse(warehouse.get());
        IWarehouseRepRepository.save(rep);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new BadRequestException("User not found."));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }
}
