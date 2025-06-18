package com.mercadolibre.melifrescosg9w31.unit.auth;

import com.mercadolibre.melifrescosg9w31.dtos.request.RegisterRequest;
import com.mercadolibre.melifrescosg9w31.entity.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class RegisterRequestTest {
    @Test
    void testAllArgsConstructor() {
        RegisterRequest request = new RegisterRequest("user123", "pass123", Role.BUYER);

        assertEquals("user123", request.getUsername());
        assertEquals("pass123", request.getPassword());
        assertEquals(Role.BUYER, request.getRole());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("testUser");
        request.setPassword("testPass");
        request.setRole(Role.SELLER);

        assertEquals("testUser", request.getUsername());
        assertEquals("testPass", request.getPassword());
        assertEquals(Role.SELLER, request.getRole());
    }

    @Test
    void testBuilder() {
        RegisterRequest request = RegisterRequest.builder()
                .username("builderUser")
                .password("builderPass")
                .role(Role.WAREHOUSE_REP)
                .build();

        assertEquals("builderUser", request.getUsername());
        assertEquals("builderPass", request.getPassword());
        assertEquals(Role.WAREHOUSE_REP, request.getRole());
    }

    @Test
    void testEqualsAndHashCode() {
        RegisterRequest r1 = new RegisterRequest("a", "b", Role.BUYER);
        RegisterRequest r2 = new RegisterRequest("a", "b", Role.BUYER);

        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testToString() {
        RegisterRequest request = new RegisterRequest("admin", "adminpass", Role.SELLER);
        String result = request.toString();

        assertTrue(result.contains("admin"));
        assertTrue(result.contains("adminpass"));
        assertTrue(result.contains("SELLER"));
    }
}
