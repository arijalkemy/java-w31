package com.mercadolibre.melifrescosg9w31.unit.auth;

import com.mercadolibre.melifrescosg9w31.dtos.response.AuthenticationResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationResponseTest {
    @Test
    void testAllArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse("test-token");
        assertEquals("test-token", response.getToken());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken("abc123");

        assertEquals("abc123", response.getToken());
    }

    @Test
    void testBuilder() {
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token("builder-token")
                .build();

        assertEquals("builder-token", response.getToken());
    }

    @Test
    void testEqualsAndHashCode() {
        AuthenticationResponse r1 = new AuthenticationResponse("token-value");
        AuthenticationResponse r2 = new AuthenticationResponse("token-value");

        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testToString() {
        AuthenticationResponse response = new AuthenticationResponse("secret-token");
        String result = response.toString();

        assertTrue(result.contains("secret-token"));
    }
}
