package com.mercadolibre.melifrescosg9w31.controller;

import com.mercadolibre.melifrescosg9w31.dtos.request.AuthenticationRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.RegisterRepRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.RegisterRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.AuthenticationResponse;
import com.mercadolibre.melifrescosg9w31.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/registerRep")
    public ResponseEntity<AuthenticationResponse> registerRep(
            @RequestBody RegisterRepRequest request
    ) {
        return new ResponseEntity<>(service.registerRep(request), HttpStatus.CREATED);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return new ResponseEntity<>(service.authenticate(request), HttpStatus.CREATED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentials(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }

}
