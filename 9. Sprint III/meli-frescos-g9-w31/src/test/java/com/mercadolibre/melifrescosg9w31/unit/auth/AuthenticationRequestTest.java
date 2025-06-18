package com.mercadolibre.melifrescosg9w31.unit.auth;

import com.mercadolibre.melifrescosg9w31.dtos.request.AuthenticationRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AuthenticationRequestTest {
    @Test
    void testAllArgsConstructor() {
        AuthenticationRequest request = new AuthenticationRequest("user123", "pass123");
        assertEquals("user123", request.getUsername());
        assertEquals("pass123", request.getPassword());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setUsername("john.doe");
        request.setPassword("secret");

        assertEquals("john.doe", request.getUsername());
        assertEquals("secret", request.getPassword());
    }

    @Test
    void testBuilder() {
        AuthenticationRequest request = AuthenticationRequest.builder()
                .username("alice")
                .password("wonderland")
                .build();

        assertEquals("alice", request.getUsername());
        assertEquals("wonderland", request.getPassword());
    }

    @Test
    void testEqualsAndHashCode() {
        AuthenticationRequest r1 = new AuthenticationRequest("user", "pass");
        AuthenticationRequest r2 = new AuthenticationRequest("user", "pass");

        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testToString() {
        AuthenticationRequest request = new AuthenticationRequest("bob", "builder");
        String result = request.toString();

        assertTrue(result.contains("bob"));
        assertTrue(result.contains("builder"));
    }
}
