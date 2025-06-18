package com.mercadolibre.melifrescosg9w31.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.melifrescosg9w31.entity.Role;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class TestingToken {
    public static String obtenerToken(MockMvc mockMvc, ObjectMapper objectMapper, Role role) throws Exception {
        String username = "testuser" + UUID.randomUUID();
        String password = "testpass";

        String authResponse = mockMvc.perform(post("/api/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"role\":\"" + role.name() + "\"}")).andReturn().getResponse().getContentAsString();
        String response = mockMvc.perform(post("/api/v1/auth/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("RESPONSE: " + response);
        return objectMapper.readTree(response).get("token").asText();
    }
}
